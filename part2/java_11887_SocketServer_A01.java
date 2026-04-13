import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_11887_SocketServer_A01 {

    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocketChannel server = ServerSocketChannel.open()) {
            server.bind(new InetSocketAddress(8080));
            server.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            server.configureBlocking(false);

            LOGGER.info("Server started on port 8080");

            while (true) {
                SocketChannel client = server.accept();
                if (client != null) {
                    LOGGER.info("Client connected: " + client.socket().getRemoteSocketAddress());
                    client.configureBlocking(false);
                }
            }
        } catch (IOException e) {
            LOGGER.severe("Failed to setup server: " + e.getMessage());
        }
    }
}