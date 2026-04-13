import java.io.IOException;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_39348_SocketServer_A07 {

    public static void main(String[] args) throws CertificateException, KeyStoreException, IOException {
        // create a keystore using a truststore
        KeyStore truststore = KeyStore.getInstance("JKS");
        truststore.load(getClass().getResourceAsStream("/truststore.jks"), "truststorepassword".toCharArray());

        // create a keystore using a keystore
        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(getClass().getResourceAsStream("/keystore.jks"), "keystorepassword".toCharArray());

        // setup SSLServerSocketFactory with the keystore and truststore
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, truststore, keystore);

        // server listening
        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuthentication(true);
            System.out.println("Client Authenticated");

            // authenticate the client
            sslSocket.startHandshake();
            System.out.println("Handshake Complete");
            // continue with communication
        }
    }
}