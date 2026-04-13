import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_09207_SocketServer_A08 {
    public static final String MD5 = "MD5";
    private final MessageDigest messageDigest;

    public java_09207_SocketServer_A08() throws NoSuchAlgorithmException {
        this.messageDigest = MessageDigest.getInstance(MD5);
    }

    public void startServer(int port) throws IOException {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);

            System.out.println("Server is listening on port " + port);

            while (true) {
                SocketChannel clientChannel = serverSocketChannel.accept();
                if (clientChannel != null) {
                    handleClient(clientChannel);
                }
            }
        }
    }

    private void handleClient(SocketChannel clientChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder stringBuilder = new StringBuilder();

        while (clientChannel.read(buffer) != -1) {
            buffer.flip();
            stringBuilder.append(StandardCharsets.UTF_8.decode(buffer));
        }

        String request = stringBuilder.toString();

        // Add integrity-sensitive operations here (like hashing, encryption, etc.)
        // Here we only demonstrate MD5 hashing, but you can use other algorithms as well.
        byte[] hash = messageDigest.digest(request.getBytes(StandardCharsets.UTF_8));

        // Send response
        String response = String.format("MD5(%s) = %x", request, bytesToHex(hash));
        clientChannel.write(ByteBuffer.wrap(response.getBytes(StandardCharsets.UTF_8)));

        clientChannel.close();
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        new SocketServer().startServer(8080);
    }
}