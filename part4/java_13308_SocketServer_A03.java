import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13308_SocketServer_A03 {

    private static final String SSL_PROTOCOL = "SSL";

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;

        try {
            // Create SSL Server Socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);

            // Setup SSL Context
            SSLContext sslContext = SSLContext.getInstance(SSL_PROTOCOL);
            sslContext.init(null, new TrustManager[]{new TrustAllCertsTrustManager()}, null);
            serverSocket.setSSLSocketFactory(sslContext.getSocketFactory());

            // Wait for client connection
            System.out.println("Waiting for client connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Handle client request
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String request = new String(buffer, 0, bytesRead);
            System.out.println("Received request: " + request);

            // Validate request (This is a simple example and not secure against injection)
            if(request.contains("DROP_TABLE")) {
                System.out.println("Drop table injection detected!");
                // Send response
                String response = "Drop table injection detected!";
                socket.getOutputStream().write(response.getBytes());
            } else {
                // Send response
                String response = "Hello, " + request + "!";
                socket.getOutputStream().write(response.getBytes());
            }

            socket.close();
            serverSocket.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    // Trust all certs
    static class TrustAllCertsTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isTrusted(X509Certificate[] certs) {
            return true;
        }
    }
}