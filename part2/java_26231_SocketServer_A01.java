import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_26231_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT, 10000, InetAddress.getByName("localhost"));

            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setCertificateAccepted(new CertificateAcceptor());

            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Accepted new connection from: " + socket.getRemoteSocketAddress());

                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Accepted new SSL connection from: " + sslSocket.getRemoteSocketAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }
}

class CertificateAcceptor implements javax.net.ssl.CertificateAcceptor {
    public boolean accept(String s, SSLSocket socket) {
        return true;
    }

    public boolean accept(String s, X509Certificate x509Certificate) {
        return true;
    }

    public boolean accept(String s, String s1, X509Certificate x509Certificate, String s2) {
        return true;
    }
}