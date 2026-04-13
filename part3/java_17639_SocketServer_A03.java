import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_17639_SocketServer_A03 {

    private static final int PORT = 8888;
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    private SSLServerSocket serverSocket;
    private Socket clientSocket;
    private ExecutorService executor;

    public java_17639_SocketServer_A03() {
        executor = Executors.newFixedThreadPool(5);
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream("/keystore"), KEYSTORE_PASSWORD.toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(getClass().getResourceAsStream("/truststore"), TRUSTSTORE_PASSWORD.toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, trustStore, null);

            serverSocket.setSSLContext(sslContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        new Thread(() -> {
            while (true) {
                try {
                    clientSocket = serverSocket.accept();
                    System.out.println("Accepted new connection from: " + clientSocket.getRemoteSocketAddress());

                    executor.execute(new SocketHandler(clientSocket));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private class SocketHandler implements Runnable {

        private Socket socket;
        private InputStream inputStream;

        public java_17639_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                inputStream = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                byte[] bytes = new byte[1024];
                int length;
                while ((length = inputStream.read(bytes)) > 0) {
                    // Process the received data
                }
                socket.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer().startServer();
    }
}