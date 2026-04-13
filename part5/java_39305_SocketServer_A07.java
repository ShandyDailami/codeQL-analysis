import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLServerSocketChannel;
import javax.net.ssl.SSLServerSocketChannel.Accept;
import javax.net.ssl.SSLSocketChannel;

public class java_39305_SocketServer_A07 {
    private final int port;

    public java_39305_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        SSLServerSocketChannel sslServerSocketChannel = null;
        try {
            sslServerSocketChannel = SSLServerSocketChannel.open();
            sslServerSocketChannel.bind(new InetSocketAddress(port));
            sslServerSocketChannel.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            // You need to provide your own KeyStore and truststore
            keyStore.load(getClass().getResourceAsStream("/client.jks"), "password".toCharArray());

            sslServerSocketChannel.setKeyStore(keyStore);
            sslServerSocketChannel.setKeyStorePassword("password".toCharArray());

            SSLSocketChannel sslSocketChannel = sslServerSocketChannel.accept();
            sslSocketChannel.handshake();

            // Now you can use the SSLSocketChannel for communication
        } catch (KeyStoreException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            if (sslServerSocketChannel != null) sslServerSocketChannel.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(8443).start();
    }
}