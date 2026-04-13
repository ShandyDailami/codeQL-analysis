import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class java_04010_SocketServer_A07 {
    private static final String KEYSTORE_PATH = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_PATH = "path_to_your_truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) serverChannel.accept().accept();

        sslServerSocketFactory.setKeyStore(getKeyStore(KEYSTORE_PATH, KEYSTORE_PASSWORD));
        sslServerSocketFactory.setKeyStorePassword(KEYSTORE_PASSWORD);
        sslServerSocketFactory.setTrustStore(getKeyStore(TRUSTSTORE_PATH, TRUSTSTORE_PASSWORD));
        sslServerSocketFactory.setTrustStorePassword(TRUSTSTORE_PASSWORD);

        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket();

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String response = "Hello, client!";
            buffer.put(response.getBytes(StandardCharsets.UTF_8));
            buffer.flip();

            while (buffer.hasRemaining()) {
                clientSocket.write(buffer);
            }

            clientSocket.close();
        }
    }

    private static KeyStore getKeyStore(String path, String password) throws IOException, Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream(path), password.toCharArray());
        return keyStore;
    }
}