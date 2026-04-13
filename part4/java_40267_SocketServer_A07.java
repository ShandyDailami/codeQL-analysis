import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Optional;

public class java_40267_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                // No client connected, wait for a while
                Optional.ofNullable(socketChannel).ifPresent(SocketChannel::close);
                continue;
            }

            socketChannel.configureBlocking(false);

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (socketChannel.read(buffer) != -1) {
                buffer.flip();
                // Process the received data
                System.out.println("Received: " + new String(buffer.array()));
                buffer.clear();
            }

            socketChannel.close();
        }
    }
}