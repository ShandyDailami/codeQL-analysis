import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15902_SocketServer_A01 {
    private static final String SSL_PROTOCOL = "SSL";
    private static final String SERVER_SOCKET_NAME = "Server Socket";

    public static void main(String[] args) {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);
            System.out.println("Waiting for client connection on port " + sslServerSocket.getPort());
            Socket clientSocket = sslServerSocket.accept();
            System.out.println("Client connected.");
            SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
            SSLContext sslContext = SSLContext.getInstance(SSL_PROTOCOL);
            sslContext.init(null, new TrustManager[]{new TrustedCertsTrustManager()}, null);
            sslSocket.setSSLContext(sslContext);
            // Here you can use the SSLSocket object for your specific operations
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory() {
        SSLServerSocketFactory sslServerSocketFactory = null;
        try {
            SSLServerSocketFactory sslServerSocketFactoryTmp = SSLServerSocketFactory.getDefault();
            if (sslServerSocketFactoryTmp.getDefaultCertificate() == null) {
                throw new IllegalStateException("Default SSL certificate not available.");
            }
            sslServerSocketFactory = (SSLServerSocketFactory) sslServerSocketFactoryTmp.clone();
            sslServerSocketFactory.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sslServerSocketFactory;
    }
}