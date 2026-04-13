import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SSLServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_27452_SocketServer_A03 {
    private static final String SSL_KEYSTORE = "path_to_your_keystore";
    private static final String SSL_KEYSTORE_PASSWORD = "password_for_your_keystore";
    private static final String SSL_TRUSTSTORE = "path_to_your_truststore";
    private static final String SSL_TRUSTSTORE_PASSWORD = "password_for_your_truststore";

    public static void main(String[] args) throws IOException {
        SSLServerSocketChannel sslServerSocketChannel = null;
        try {
            sslServerSocketChannel = SSLServerSocketChannel.open();
            sslServerSocketChannel.bind(new InetSocketAddress(8080));
            sslServerSocketChannel.getChannel().configureBlocking(false);

            sslServerSocketChannel.setNeedClient(true);
            sslServerSocketChannel.setKeyStorePath(SSL_KEYSTORE);
            sslServerSocketChannel.setKeyStorePassword(SSL_KEYSTORE_PASSWORD);
            sslServerSocketChannel.setTrustStorePath(SSL_TRUSTSTORE);
            sslServerSocketChannel.setTrustStorePassword(SSL_TRUSTSTORE_PASSWORD);

            System.out.println("Server started with port 8080");

            while (true) {
                SocketChannel sock = sslServerSocketChannel.accept();
                sock.configureBlocking(false);

                System.out.println("Accepted connection from " + sock.socket().getRemoteSocketAddress());
                // handle the sock
            }
        } finally {
            sslServerSocketChannel.close();
        }
    }
}