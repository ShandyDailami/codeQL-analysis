import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_22497_SocketServer_A01 {

    private static final String SERVER_SOFTWARE = "YourSoftware";
    private static final String CERT_PATH = "path/to/your/certificate.pem";
    private static final String KEY_PATH = "path/to/your/key.pem";
    private static final String CA_PATH = "path/to/your/ca.pem";

    public static void main(String[] args) throws Exception {

        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080,
                ServerSocket.BACKLOG_COUNT, null, getCertificate(CERT_PATH, KEY_PATH, CA_PATH));

        sslServerSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            clientSocket.setNeedClientAuth(true);

            OutputStream out = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello from SocketServer");

            SSLSession session = clientSocket.getSession();
            SSLPeer primeKey = session.getPeerPrime();
            if (primeKey != null) {
                writer.println("Prime key: " + primeKey.toString());
            }

            clientSocket.close();
        }
    }

    private static KeyStore getCertificate(String certificateFile, String keyFile, String caFile) throws Exception {

        KeyStore keystore = KeyStore.getInstance("JKS");
        char[] password = "password".toCharArray();

        // Load the certificate and private key.
        keystore.load(new FileInputStream(certificateFile), password);

        // Load the certificate authority.
        CertificateFactory cf = CertificateFactory.getInstance("X509");
        Certificate ca = cf.generateCertificate(new FileInputStream(caFile));

        // Set the certificate authority.
        keystore.setCertificateEntry("ca", ca);

        // Load the private key.
        keystore.load(new FileInputStream(keyFile), password);

        return keystore;
    }
}