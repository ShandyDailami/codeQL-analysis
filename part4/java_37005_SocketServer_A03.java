import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class java_37005_SocketServer_A03 {
    private static final SecureRandom random = new SecureRandom();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!";

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server started, waiting for connections on port 8080");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                continue;
            }

            socketChannel.configureBlocking(false);

            String randomPassword = generateRandomPassword();
            socketChannel.write(ByteBuffer.wrap(("Hello " + randomPassword).getBytes(StandardCharsets.UTF_8)));

            socketChannel.close();
        }
    }

    private static String generateRandomPassword() {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        for (int i = 0; i < 16; i++) {
            buffer.put(random.nextLong() % CHARACTERS.length());
        }

        return new String(buffer.array(), StandardCharsets.UTF_8);
    }
}