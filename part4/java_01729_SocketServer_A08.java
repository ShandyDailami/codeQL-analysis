import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketChannel;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_01729_SocketServer_A08 {
    public static void main(String[] args) throws IOException, CertificateException {
        // Setup SSLContext for server
        SSLContext sslContext = SSLContext.getInstance("SSL");
        KeyStore keyStore = KeyStore.getInstance("JKS");

        // Load your key store
        keyStore.load(ClassLoader.getSystemResourceAsStream("keystore.jks"), "password".toCharArray());

        sslContext.init(keyStore, null, null);

        // Setup SSLServerSocket
        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(8080);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

            // Setup SSLServerSocketChannel
            SSLServerSocketChannel sslChannel = (SSLServerSocketChannel) sslContext.getServerSocketChannel();
            sslChannel.accept(clientSocket);

            // Handle client here
        }
    }
}