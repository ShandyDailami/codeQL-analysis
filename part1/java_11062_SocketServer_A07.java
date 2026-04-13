import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_11062_SocketServer_A07 {

    public static void main(String[] args) throws KeyStoreException, CertificateException, IOException {
        // Create a KeyStore and TrustManager
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(getClass().getResourceAsStream("/truststore.jks"), "truststorepassword".toCharArray());
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(trustStore);
        trustManagerFactory.init(new java.security.SecureRandom());

        // Create a KeyStore and Certificate
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream("/keystore.jks"), "keystorepassword".toCharArray());

        // Create a SSLServerSocketFactory
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.create(new ServerSocket(12345));
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setTrustManager(trustManagerFactory);

        // Create a ServerSocket and accept SSL Socket
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket();
        Socket clientSocket = serverSocket.accept();

        // Create a SSLSocket and setup SSL/TLS
        SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSocket(clientSocket, true);
        sslSocket.setNeedClientAuth(true);

        // Continue the connection...

        // ...
    }
}