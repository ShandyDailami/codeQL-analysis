import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;

public class java_17585_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        // Setup the SSL context
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SocketServer.class.getResourceAsStream("/keystore.jks"), "password".toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, "password".toCharArray());
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, null, null);

        // Setup the SSL server socket
        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(12345);

        while (true) {
            // Wait for a client to connect
            SSLSocket sslSocket = (SSLSocket) serverSocket.accept();

            // Get the output stream of the client
            OutputStream out = sslSocket.getOutputStream();

            // Send a message to the client
            out.write("Hello, client!\r\n".getBytes());
            out.flush();

            // Close the connection
            sslSocket.close();
        }
    }
}