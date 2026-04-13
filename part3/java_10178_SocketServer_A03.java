import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Objects;

public class java_10178_SocketServer_A03 {

    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (Objects.nonNull(clientSocketChannel)) {
                ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
                clientSocketChannel.read(buffer);

                // Handle security sensitive operations related to injection attacks
                String receivedMessage = new String(buffer.array(), 0, buffer.position());

                // Do something with the received message
                System.out.println("Received message: " + receivedMessage);

                buffer.flip();
                clientSocketChannel.write(buffer);
                buffer.clear();
            }
        }
    }
}