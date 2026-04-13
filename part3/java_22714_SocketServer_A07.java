import java.net.*;
import javax.net.ssl.*;

public class java_22714_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            // Create a SSLServerSocket for the server
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);
            serverSocket.setNeedClientAuth(true);

            // Create a new thread for the socket
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAllCertsTrustManager() }, new java.security.SecureRandom());
            serverSocket.setSSLContext(sslContext);

            // Accept incoming connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
                System.out.println("Client connected: " + sslSocket.getRemoteSocketAddress());
                // Handle the connection
                // ...
            }
        } finally {
            serverSocket.close();
        }
    }
}