import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_29323_SocketServer_A03 {
    private static final String CLIENT_SSL_VERSION = "SSLv3";
    private static final String SERVER_KEY_STORE = "server.jks";
    private static final String SERVER_KEY_STORE_PASSWORD = "password";
    private static final String CLIENT_KEY_STORE = "client.jks";
    private static final String CLIENT_KEY_STORE_PASSWORD = "password";
    private static final String TRUSTSTORE = "truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("127.0.0.1");

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, 100, address);

        sslServerSocket.setEnabledCSV(true);
        sslServerSocket.setEnabledECDHE(true);

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setEnabledCSV(true);
            sslSocket.setEnabledECDHE(true);

            System.out.println("New connection from " + sslSocket.getInetAddress().getHostAddress());

            X509Certificate[] certificates = sslSocket.getLocalCertificates();
            for (X509Certificate certificate : certificates) {
                System.out.println("Certificate: " + certificate.toString());
            }

            // do some secure operations here

            sslSocket.close();
        }
    }
}