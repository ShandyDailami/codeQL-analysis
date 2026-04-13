import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_03152_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create a server socket channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server started. Listening for client connections...");

        while (true) {
            // Accept a new connection
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel == null) continue;

            // Setup a non-blocking read
            clientSocketChannel.configureBlocking(false);

            // Handle the client connection
            new Thread(() -> handleClient(clientSocketChannel)).start();
        }
    }

    private static void handleClient(SocketChannel clientSocketChannel) {
        try {
            // Read from the client
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            clientSocketChannel.read(buffer);

            // TODO: Implement your security-sensitive operations here.
            // For example, check if the integrity of the data is correct.
            // If not, close the connection.

            clientSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}