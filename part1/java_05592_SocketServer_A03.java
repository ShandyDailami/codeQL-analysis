import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketChannel;

public class java_05592_SocketServer_A03 {

    private static final String KEYSTORE_PATH = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "alias";
    private static final String TRUSTSTORE_PATH = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLContext sslContext = createSSLContext(KEYSTORE_PATH, KEYSTORE_PASSWORD, TRUSTSTORE_PATH, TRUSTSTORE_PASSWORD, KEY_ALIAS);

        SSLSocketChannel sslChannel = (SSLSocketChannel) sslContext.getChannel();
        sslChannel.bind(StandardSocketOptions.LOCAL_PORT);
        sslChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            SocketChannel channel = sslChannel.accept();
            if (channel != null) {
                channel.configureBlocking(false);
                while (channel.isConnectionReady()) {
                    int r = channel.read(buffer);
                    if (r < 0) {
                        throw new IOException("Failed to read message from client: " + r);
                    } else if (r == 0) {
                        break;
                    } else {
                        String request = new String(buffer.array(), StandardCharsets.UTF_8);
                        System.out.println("Received: " + request);

                        // TODO: process the request here

                        String response = "Hello, client!";
                        buffer.clear();
                        buffer.put(response.getBytes(StandardCharsets.UTF_8));
                        channel.write(buffer.flip());
                    }
                }
                channel.close();
            }
        }
    }

    private static SSLContext createSSLContext(String keystorePath, String keystorePassword, String truststorePath, String truststorePassword, String keyAlias) throws Exception {
        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(getClass().getClassLoader().getResourceAsStream(keystorePath), keystorePassword.toCharArray());

        Key key = keystore.getKey(keyAlias, keystorePassword.toCharArray());

        Certificate certificate = keystore.getCertificate(keyAlias);

        if (certificate == null) {
            throw new Exception("Certificate not found");
        }

        KeyStore truststore = KeyStore.getInstance("JKS");
        truststore.load(getClass().getClassLoader().getResourceAsStream(truststorePath), truststorePassword.toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keystore, key, truststore, truststorePassword.toCharArray());
        return sslContext;
    }
}