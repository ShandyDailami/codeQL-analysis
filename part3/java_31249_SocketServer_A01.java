import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_31249_SocketServer_A01 {
    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);

            logger.info("Server started.");

            while (true) {
                SocketChannel clientChannel = serverSocketChannel.accept();
                if (clientChannel != null) {
                    logger.info("New connection from " + clientChannel);

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while (clientChannel.isConnected() && clientChannel.read(buffer) != -1) {
                        buffer.flip();
                        while (buffer.hasRemaining()) {
                            byte b = buffer.get();
                            if (b == 'x') {
                                // This is a violation of Broken Access Control.
                                // We're trying to read from the client and if we find 'x'
                                // we're going to send back a response.
                                clientChannel.write(ByteBuffer.wrap("Acknowledged".getBytes()));
                            }
                            buffer.clear();
                       
                        }
                    }
                    clientChannel.close();
                }
            }
        } catch (IOException e) {
            logger.severe("I/O error occurred: " + e.getMessage());
        }
    }
}