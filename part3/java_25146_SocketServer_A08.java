import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_25146_SocketServer_A08 {

    public static void main(String[] args) throws Exception {

        int port = 12345;

        // Create a SSLServerSocket
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketServerSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port, null, null);
            sslServerSocket.setNeedClientAuth(true);

            // Setup SSLContext
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            sslServerSocket.setSSLContext(sslContext);

            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Client connected!");

                // Create Input and Output Streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Send a message
                out.writeUTF("Hello, Client!");

                // Close the connection
                in.close();
                out.close();
                socket.close();
            }
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }

    // Inner class for handling the client connection
    static class ClientHandler implements Runnable {

        private Socket socket;

        public java_25146_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive a message
                String message = in.readLine();
                System.out.println("Server received: " + message);

                // Send a response
                out.writeUTF("Hello, Client!");

                // Close the connection
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Inner class for handling the client connection
    static class TrustAllCerts extends X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            // Not used
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            // Not used
        }
    }
}