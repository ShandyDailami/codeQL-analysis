import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_04493_SocketServer_A01 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        logger.info("Starting secure server on port " + port);

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);

            logger.info("Accepting new connections");
            while (true) {
                SocketChannel clientChannel = serverSocketChannel.accept();
                if (clientChannel == null) {
                    Thread.yield();
                    continue;
                }

                logger.info("Accepted connection from " + clientChannel.socket().getRemoteSocketAddress());
                clientChannel.configureBlocking(false);

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (clientChannel.read(buffer) != -1) {
                    buffer.flip();
                    process(buffer);
                    buffer.clear();
                }

                clientChannel.close();
            }
        } catch (IOException e) {
            logger.severe("Exception from main method");
            e.printStackTrace();
        }
    }

    private static void process(ByteBuffer buffer) {
        // Implement security-sensitive operations related to A01_BrokenAccessControl
        // For example, decryption, hashing, etc.
        // Implementing security measures for this example is out of the scope of this example.
    }
}