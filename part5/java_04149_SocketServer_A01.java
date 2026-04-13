import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.cert.Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_04149_SocketServer_A01 {
    private static final String KEYSTORE_FILE = "keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_FILE = "truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = null;
        SSLServerSocket sslServerSocket = null;

        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE_FILE), KEYSTORE_PASSWORD.toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(TRUSTSTORE_FILE), TRUSTSTORE_PASSWORD.toCharArray());

            Certificate[] certificates = trustStore.getCertificateChain("myCert");
            if (certificates == null || certificates.length == 0) {
                throw new Exception("Truststore does not contain a certificate");
            }

            sslServerSocketFactory = (SSLServerSocketFactory) keyStore.getSocketFactory();

            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(new InetSocketAddress(8443), null, certificates);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                sslSocket.startHandshake();
                sslServerSocket.setNeedClientAuth(true);
                sslServerSocket.setDegraded(true);
                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sslServerSocket.close();
            sslServerSocketFactory.getDefaultCertificateAcceptChain();
        }
    }
}