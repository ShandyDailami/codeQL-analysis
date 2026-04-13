import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_29457_SocketServer_A08 {
    private static final String KEYSTORE = "server.jks";
    private static final char[] KEYSTORE_PASSWORD = "password".toCharArray();
    private static final char[] PASSWORD = "password".toCharArray();
    private static final String TRUSTSTORE = "truststore.jks";
    private static final char[] TRUSTSTORE_PASSWORD = "truststorepassword".toCharArray();
    private static final String ALIAS = "sslserver";

    public static void main(String[] args) throws KeyStoreException, CertificateException, IOException, NoSuchAlgorithmException, KeyManagementException {
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunKSAPI");
        kmf.init(new org.apache.jctools.queues.BlockingQueue(new java.security.KeyStore.PasswordCallback(KEYSTORE_PASSWORD)), null);

        KeyStore tks = KeyStore.getInstance("JKS");
        tks.load(new java.io.FileInputStream(TRUSTSTORE), TRUSTSTORE_PASSWORD);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) kmf.getKeyManagerFactory().getDefaultKeyStorePasswordCallback().getPasswordCallback().getKeyStore().getKeyStore();
        SSLServerSocket ss = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
        ss.setNeedClientAuth(true);
        ss.setCertificateManager(kmf);

        Socket s = ss.accept();
        SSLSocket sslsock = (SSLSocket) ss.accept();
        sslsock.setNeedClientAuth(true);

        System.out.println("Connection from: " + s.getInetAddress().getHostAddress());

        // write here your server code

        s.close();
        sslsock.close();
        ss.close();
    }
}