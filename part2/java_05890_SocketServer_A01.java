import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_05890_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening for connections on port 8080...");

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                System.out.println("A client connected!");

                // Secure code here to handle communication with the client
                // For example, reading from the client and writing to the client
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (clientSocketChannel.read(buffer) != -1) {
                    buffer.flip();
                    clientSocketChannel.write(buffer);
                    buffer.clear();
                }

                clientSocketChannel.close();
            }
        }
    }
}