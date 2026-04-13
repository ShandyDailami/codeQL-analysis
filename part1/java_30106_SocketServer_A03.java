import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_30106_SocketServer_A03 {
    private static final String SSL_PROTOCOL = "SSL";
    private static final String SERVER_SOCKET_ADDRESS = "localhost";
    private static final int PORT = 8888;

    public static void main(String[] args) {
        SSLContext sslContext = getSSLContext();
        SSLServerSocket serverSocket = null;

        try {
            serverSocket = (SSLServerSocket) sslContext.getServerSocket(PORT);
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static void handleClient(SSLSocket clientSocket) throws IOException {
        // handle client communication here
    }

    private static SSLContext getSSLContext() {
        SSLContext sslContext = null;

        try {
            sslContext = SSLContext.getInstance(SSL_PROTOCOL);
            sslContext.init(null, null, null);
        } catch (NoSuchAlgorithmException | KeyManagementException | CertificateException e) {
            e.printStackTrace();
        }

        return sslContext;
    }
}