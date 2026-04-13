import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_07721_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(5000));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 5000");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("New connection accepted from: " + socketChannel.getRemoteAddress());

                // Here we set non-blocking mode for the socket channel
                socketChannel.configureBlocking(false);

                // Create a buffer
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                // Read from the client
                int bytesRead = socketChannel.read(buffer);
                if (bytesRead == -1) {
                    System.out.println("Connection closed by client");
                    socketChannel.close();
                } else {
                    // Here you can process the data if required
                    System.out.println("Received: " + new String(buffer.array()));

                    // Echo back to client
                    buffer.flip();
                    socketChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }
}