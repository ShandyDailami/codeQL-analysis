import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_27904_SocketServer_A08 {
    private static final Logger logger = Logger.getLogger(VanillaJavaSocketServer.class.getName());

    public static void main(String[] args) {
        runServer();
    }

    private static void runServer() {
        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);

            logger.info("Server started on port 8080");

            while (true) {
                SocketChannel clientSocketChannel = serverSocketChannel.accept();
                if (clientSocketChannel != null) {
                    handleClient(clientSocketChannel);
                }
            }
        } catch (IOException e) {
            logger.severe("Server failed to start");
            e.printStackTrace();
        } finally {
            if (serverSocketChannel != null) {
                try {
                    serverSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(SocketChannel clientSocketChannel) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (clientSocketChannel.read(buffer) != -1) {
                buffer.flip();

                // Perform integrity checks
                // This is a simple example and may not be suitable for all applications.
                // It's not recommended to implement this in a real-world application.
                if (buffer.hasArray()) {
                    logger.warning("Integrity failure detected!");
                }

                buffer.clear();
            }

            clientSocketChannel.close();
        } catch (IOException e) {
            logger.severe("Failed to handle client");
            e.printStackTrace();
        }
    }
}