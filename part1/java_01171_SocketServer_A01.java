import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_01171_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080");

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                System.out.println("Connected client: " + clientSocketChannel.socket().getRemoteSocketAddress());

                // Read data from client
                ByteBuffer buffer = ByteBuffer.allocateDirect(16);
                clientSocketChannel.read(buffer);
                buffer.flip();

                // Process data (here we just echo the data back)
                while (buffer.hasRemaining()) {
                    clientSocketChannel.write(buffer);
                }

                // Clean up
                clientSocketChannel.close();
            }
        }
    }
}