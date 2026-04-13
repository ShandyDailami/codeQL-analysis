import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_06486_SocketServer_A08 {
    private static final Logger logger = Logger.getLogger(SecureEchoServer.class.getName());

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new java.net.InetSocketAddress(8080));
        serverSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
        serverSocketChannel.setOption(StandardSocketOptions.SO_KERNEL, true);
        serverSocketChannel.configureBlocking(false);

        logger.info("Secure Echo Server started on port 8080");

        while (true) {
            SelectionKey key = serverSocketChannel.select().iterator().next();
            if (key.isValid()) {
                if (key.isAcceptable()) {
                    SocketChannel clientChannel = serverSocketChannel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
                    clientChannel.setOption(StandardSocketOptions.SO_KERNEL, true);

                    logger.info("New connection from " + clientChannel.socket().getRemoteSocketAddress());
                    clientChannel.register(serverSocketChannel, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                } else if (key.isReadable()) {
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();

                    if (clientChannel.read(buffer) == -1) {
                        clientChannel.close();
                    } else {
                        buffer.flip();
                        clientChannel.write(buffer);
                        buffer.clear();
                   
                        logger.info("Received: " + new String(buffer.array()));
                    }
                }
            }
        }
    }
}