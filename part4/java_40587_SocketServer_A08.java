import java.io.IOException;
import java.net.InetSocketAddr;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_40587_SocketServer_A08 {

    public static void main(String[] args) throws IOException, CertificateException {
        // Create a KeyStore that contains the private key for the server
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("keystore.jks"), "password".toCharArray());

        // Create a SSLSocketFactory that uses the KeyStore and trusts all CAs
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword("password");

        // Create a SSLServerSocket and bind it to a port
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443);
        serverSocket.bind(new InetSocketAddr(8443));

        while (true) {
            // Wait for a client to connect
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

            // Perform a basic SSL handshake
            clientSocket.startHandshake();

            // Get the peer's certificate
            SSLCertificate certificate = (SSLCertificate) clientSocket.getSession().getPeerCertificate();
            System.out.println("Client certificate: " + certificate.toString());

            // Close the client socket
            clientSocket.close();
        }
    }
}