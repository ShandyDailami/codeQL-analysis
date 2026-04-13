import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketChannel;

public class java_39384_SocketServer_A07 {

    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws IOException, CertificateException {
        SSLContext sslContext = createSSLContext(KEYSTORE_LOCATION, KEYSTORE_PASSWORD, TRUSTSTORE_LOCATION, TRUSTSTORE_PASSWORD);

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(StandardSocketOptions.SO_BACKLOG, 100);
        serverChannel.configureBlocking(false);

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            if (clientChannel != null) {
                SSLSocketChannel sslChannel = (SSLSocketChannel) clientChannel.configureBlocking(false);
                sslChannel.bind(StandardSocketOptions.SO_BACKLOG, 100);
                sslChannel.setNeedClientAuth(true);
                sslChannel.setSSLContext(sslContext);

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (sslChannel.read(buffer) != -1) {
                    // process the data here
                }

                sslChannel.close();
            }
        }
    }

    private static SSLContext createSSLContext(String keyStorePath, String keyStorePassword,
                                                String trustStorePath, String trustStorePassword) throws IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new java.io.FileInputStream(keyStorePath), keyStorePassword.toCharArray());

        TrustStore trustStore = TrustStore.getInstance("JKS");
        trustStore.load(new java.io.FileInputStream(trustStorePath), trustStorePassword.toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, trustStore, null);
        return sslContext;
    }
}