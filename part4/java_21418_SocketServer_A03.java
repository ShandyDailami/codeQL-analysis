import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocketChannel;
import javax.net.ssl.SSLServerSocketChannel.Authentication;
import javax.net.ssl.SSLSocketChannel;
import javax.net.ssl.TrustStore;

public class java_21418_SocketServer_A03 {

    public static void main(String[] args) throws IOException, InterruptedException {
        String keyStorePath = "/path/to/keystore.jks";
        String keyStorePassword = "password";
        String keyPassword = "password";

        KeyStore keystore = loadKeyStore(keyStorePath, keyStorePassword);
        Key key = keystore.getKey("alias", keyPassword.toCharArray());

        SSLServerSocketChannel sslChannel = (SSLServerSocketChannel) SSLServerSocketChannel.open();
        sslChannel.bind(null); // bind to any available port
        sslChannel.setOption(StandardSocketOptions.SO_BACKLOG, 10);
        sslChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);

        sslChannel.configureBlocking(false);
        SSLSocketChannel sslSocketChannel = sslChannel.accept();

        sslSocketChannel.configureBlocking(false);

        Authentication clientAuth = sslChannel.getClientAuth();
        sslSocketChannel.setOption(StandardSocketOptions.SSL_SERVER_SIDE_CHANNEL_CONTEXT_CREATION, true);

        sslSocketChannel.write(ByteBuffer.wrap("Client Certificate Verified".getBytes()));
        sslSocketChannel.close();
    }

    private static KeyStore loadKeyStore(String path, String password) throws IOException, IllegalArgumentException, UnsupportedOperationException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new java.io.FileInputStream(path), password.toCharArray());
        return keyStore;
    }
}