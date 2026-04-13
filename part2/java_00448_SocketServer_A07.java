import java.net.*;
import java.io.*;
import javax.net.ssl.*;

public class java_00448_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        try {
            // Load the server certificate and key
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            sslServerSocket.setNeedClientAuth(true);

            // Accept client connection
            sslSocket = (SSLSocket) sslServerSocket.accept();

            // Enable SSL
            sslSocket.startHandshake();

            // Get the peer's certificate
            X509Certificate cert = (X509Certificate) sslSocket.getRemoteCertificate();
            System.out.println("Peer's certificate: " + cert.getSubjectDN());

            // Close the socket
            sslSocket.close();

        } catch (SSLException se) {
            se.printStackTrace();
        } finally {
            if (sslServerSocket != null) sslServerSocket.close();
            if (sslSocket != null) sslSocket.close();
        }
    }
}