import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_40163_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080...");

        while (true) {
            SocketChannel clientChannel = serverSocketChannel.accept();
            if (clientChannel != null) {
                System.out.println("Accepted connection from " + clientChannel);

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (clientChannel.read(buffer) != -1) {
                    buffer.flip();
                    // Perform security-sensitive operations related to A08_IntegrityFailure here
                    // For now, just echo the message back to the client
                    clientChannel.write(buffer);
                    buffer.clear();
                }
                clientChannel.close();
            }
        }
    }
}