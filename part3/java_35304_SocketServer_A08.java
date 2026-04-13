import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_35304_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        try {
            // create a SSL server socket with the specified port and buffer size
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, 54321);

            // set the accepted request queue size to 5
            sslServerSocket.setReuseAddress(true);

            // trust all SSL certificates
            sslServerSocket.setNeedClientAuthentication(true);
            sslServerSocket.setAcceptedQueueSize(5);

            // load SSL certificate from a keystore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("keystore.jks"), "password".toCharArray());

            sslServerSocket.setKeyStore(keyStore);
            sslServerSocket.setKeyStorePassword("password");

            while (true) {
                // accept a client connection
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

                // get the client's InetSocketAddress
                InetSocketAddress isa = (InetSocketAddress) sslSocket.getRemoteSocketAddress();
                logger.log(Level.INFO, "Accepted connection from " + isa.getHostName());

                // handle the client connection
                // ...

                // close the client connection
                sslSocket.close();
            }
        } catch (ClassNotFoundException | IOException | CertificateException | NullPointerException e) {
            logger.log(Level.SEVERE, "Failed to start server", e);
        }
    }
}