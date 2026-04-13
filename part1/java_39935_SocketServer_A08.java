import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

public class java_39935_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        int port = 8888;

        // Create a selector
        Selector selector = Selector.open();

        // Create a server socket channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        // Register the server socket channel to the selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server is listening on port " + port);

        // Infinite loop to accept client connections
        while (true) {
            // Wait for any incoming connections
            selector.select();

            // Iterate over the selected keys
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                // Handle the accept operation
                if (key.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                    SocketChannel clientSocketChannel = serverSocketChannel.accept();
                    clientSocketChannel.configureBlocking(false);

                    // Register the client socket channel to the selector
                    clientSocketChannel.register(selector, SelectionKey.OP_READ);
                }

                // Handle the read operation
                else if (key.isReadable()) {
                    SocketChannel clientSocketChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    clientSocketChannel.read(buffer);
                    String received = new String(buffer.array(), 0, buffer.position());
                    System.out.println("Received: " + received);

                    // Echo back received message
                    buffer.flip();
                    clientSocketChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }
}