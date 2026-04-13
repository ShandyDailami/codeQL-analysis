import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_39978_SocketServer_A08 {
    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);

            logger.info("Server started on port 8080");

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    // Perform SSL/TLS handshake here if needed

                    socketChannel.configureBlocking(false);

                    // Perform read/write operations here
                }
            }
        } catch (IOException e) {
            logger.severe("Failed to start server: " + e.getMessage());
        }
    }
}