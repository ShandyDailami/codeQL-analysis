import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_08575_SocketServer_A07 {

    public static void main(String[] args) throws IOException, CertificateException, Exception {
        // Load the key store
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SocketServer.class.getResourceAsStream("/keystore.jks"), "password".toCharArray());

        // Initialize a KeyStore that will be used to sign the server
        Key key = keyStore.getKey("alias", "password".toCharArray());

        // Load the certificate and initialize the server
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);

        System.out.println("Server started on port 8080");

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            if (clientChannel != null) {
                System.out.println("Accepted connection from " + clientChannel.socket().getRemoteSocketAddress());

                // Create a SSLContext with the key store
                SSLContext sslContext = SSLContextBuilder.create()
                        .loadKeyMaterial(keyStore, "password".toCharArray())
                        .build();

                // Enable the SSL connection
                clientChannel.configureBlocking(false);
                SSLSocketChannel sslChannel = (SSLSocketChannel) clientChannel.acquireOrCreateChannel(sslContext);
                sslChannel.set pipelined(true);

                sslChannel.write(StandardCharsets.UTF_8.encode("Hello, Client!").asWriteableByteBuffer());
                sslChannel.read(StandardCharsets.UTF_8.asReadableByteBuffer());

                sslChannel.close();
            }
        }
    }
}