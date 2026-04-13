import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Objects;

public class java_14153_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(PORT));
        serverChannel.configureBlocking(false);

        System.out.println("Server is running on port " + PORT);

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            if (Objects.nonNull(clientChannel)) {
                handleClient(clientChannel);
            }
        }
    }

    private static void handleClient(SocketChannel clientChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder response = new StringBuilder();

        while (clientChannel.read(buffer) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                response.append((char) buffer.get());
            }
            buffer.clear();
        }

        // Here you can add the logic for A08_IntegrityFailure, e.g.,
        // verify the integrity of the received data or perform any other operation.
        // For this example, we'll just print the received data.
        System.out.println("Received: " + response.toString());

        clientChannel.close();
    }
}