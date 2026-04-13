import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.cert.CertificateException;

public class java_09871_SocketServer_A03 {

    private static SSLContext sslContext;

    static void initSSLContext(String keyStorePath, String keyStorePassword,
                                String keyManagerFactoryAlgorithm) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(keyManagerFactoryAlgorithm);
        keyStore.load(new java.io.FileInputStream(keyStorePath), keyStorePassword.toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(keyManagerFactoryAlgorithm);
        keyManagerFactory.init(keyStore, keyStorePassword.toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) sslContext.getServerSocketFactory();

        SSLServerSocket socket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(new InetSocketAddress(8443), 10000, InetAddress.getByName("127.0.0.1"));

        sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(keyManagerFactory, null, null);
    }

    public static void main(String[] args) throws Exception {
        sslContext = SSLContext.getInstance("TLSv1.2");
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new java.io.FileInputStream("src/main/resources/truststore.jks"), "truststorepassword".toCharArray());
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

        SSLServerSocket socket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(new InetSocketAddress(8443), 10000, InetAddress.getByName("127.0.0.1"));

        socket.setNeedClientAuth(true);
        sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(trustStore, null, null);
    }
}