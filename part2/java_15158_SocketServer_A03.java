import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_15158_SocketServer_A03 {
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        SSLServerSocket server = null;
        try {
            // Create SSLServerSocket
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8080);

            // Enable server ssl
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{new TrustAllCertificates()}, null);
            serverSocket.setSSLSocketFactory(sslContext.getSSLSocketFactory());

            // Accept new connections
            while (true) {
                Socket client = serverSocket.accept();
                // Create thread for handling client
                Thread t = new Thread(new ClientHandler(client));
                t.start();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static class ClientHandler implements Runnable {
        private Socket socket;
        public java_15158_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.writeBytes("Hello Client\r\n");
                }
                socket.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}