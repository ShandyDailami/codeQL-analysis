import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_19602_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080.");

        while (true) {
            SocketChannel clientChannel = serverSocketChannel.accept();
            if (clientChannel != null) {
                System.out.println("A client connected!");

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (clientChannel.read(buffer) != -1) {
                    buffer.flip();
                    // Check for integrity failure here
                    if (buffer.hasRemaining()) {
                        System.out.println("Integrity failure detected!");
                        break;
                    }
                    buffer.clear();
                }

                clientChannel.close();
            }
        }
    }
}