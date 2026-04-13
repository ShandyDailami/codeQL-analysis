import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.security.SecureRandom;
import java.util.Base64;

public class java_15217_SocketServer_A07 {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getEncoder();

    public static void main(String[] args) throws IOException {
        // Create a new ServerSocket
        SocketChannel serverChannel = SocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);

        System.out.println("Server started on port 8080");

        // Accepting incoming connections
        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            if (clientChannel != null) {
                System.out.println("Client connected from: " + clientChannel.socket().getRemoteSocketAddress());
                clientChannel.configureBlocking(false);

                // Generate a random secret
                String secret = generateRandomSecret();

                // Send secret to the client
                sendSecretToClient(clientChannel, secret);

                // Start a new thread to handle the communication
                new Thread(() -> handleCommunication(clientChannel, secret)).start();
            }
        }
    }

    private static String generateRandomSecret() {
        byte[] secret = new byte[16];
        secureRandom.nextBytes(secret);
        return base64Encoder.encodeToString(secret);
    }

    private static void sendSecretToClient(SocketChannel clientChannel, String secret) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put(secret.getBytes());
        buffer.flip();
        clientChannel.write(buffer);
    }

    private static void handleCommunication(SocketChannel clientChannel, String secret) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        clientChannel.read(buffer);
        buffer.flip();
        String receivedSecret = new String(buffer.array(), 0, buffer.limit());

        if (!secret.equals(receivedSecret)) {
            throw new IOException("Authentication failed");
        }

        // Communication with the client is complete
        System.out.println("Authentication succeeded for client from: " + clientChannel.socket().getRemoteSocketAddress());
    }
}