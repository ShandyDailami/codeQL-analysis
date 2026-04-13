import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_11188_SocketServer_A07 {

    private static final int PORT = 8888;
    private static final String KEYSTORE_LOCATION = "server.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_LOCATION = "client.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            sslServerSocket = (SSLServerSocket) serverSocket.accept();
            sslServerSocket.setNeedClientAuthentication(true);

            // load keystore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

            // load truststore
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream(TRUSTSTORE_LOCATION), TRUSTSTORE_PASSWORD.toCharArray());

            // configure truststore
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, trustStore, null);
            sslServerSocket.setSSLContext(sslContext);

            while (true) {
                Socket socket = sslServerSocket.accept();
                executorService.execute(new ClientHandler(socket));
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
            executorService.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_11188_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InetAddress clientAddress = socket.getInetAddress();
                System.out.println("Client connected from: " + clientAddress.getHostAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Here is a simple message encryption example
                    String encryptedMessage = encryptMessage(message);
                    out.writeBytes(encryptedMessage + "\n");
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String encryptMessage(String message) {
            // This is a simple encryption example, you can use any encryption method you want.
            // For the sake of example, we use a simple Caesar cipher.
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : message.toCharArray()) {
                encryptedMessage.append((char) (c + 1));
            }
            return encryptedMessage.toString();
        }
    }
}