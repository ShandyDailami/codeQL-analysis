import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_30456_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        // Load the KeyStore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SecureSocketServer.class.getResourceAsStream("/client.jks"), "password".toCharArray());

        // Get the Certificate from the KeyStore
        KeyStore cos = keyStore;
        Certificate cert = cos.getCertificate("client");

        // Set up Security Manager
        Security.addProvider(new BouncyCastleProvider());

        // Initialize the Key
        Key key = KeyStoreUtils.getPrivateKey(keyStore, "client");

        // Create a server socket
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);

        System.out.println("Server started on port 8080. Waiting for connections...");

        // Wait for a connection
        SocketChannel clientChannel = serverChannel.accept();
        if (clientChannel != null) {
            System.out.println("New connection accepted from " + clientChannel.socket().getRemoteSocketAddress());

            // Send the certificate to the client
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("CERTIFICATE".getBytes());
            buffer.flip();
            clientChannel.write(buffer);

            // Receive the certificate from the client
            buffer.clear();
            clientChannel.read(buffer);
            buffer.flip();
            byte[] received = new byte[buffer.remaining()];
            buffer.get(received);
            System.out.println("Received certificate: " + new String(received));
        }

        serverChannel.close();
    }

}