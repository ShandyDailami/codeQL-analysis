import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class java_25927_SocketServer_A03 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.keyFor(SelectionKey.OP_ACCEPT).channel();

        while (true) {
            SelectionKey key = serverSocketChannel.select().iterator().next();

            if (key.isAcceptable()) {
                ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = serverSocketChannel1.accept();
                socketChannel.configureBlocking(false);
                logger.info("Connection established from " + socketChannel.socket().getRemoteSocketAddress());

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (socketChannel.read(buffer) != -1) {
                    buffer.flip();

                    // Here we use a simple implementation of a sanitizer for the string received from the client.
                    // For real-world applications, a more sophisticated sanitizer would be needed.
                    String sanitizedInput = new String(buffer.array(), StandardCharsets.UTF_8).trim();

                    logger.info("Received message: " + sanitizedInput);

                    buffer.clear();
                }

                socketChannel.close();
            }
        }
    }
}