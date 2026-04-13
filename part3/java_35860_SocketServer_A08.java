import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_35860_SocketServer_A08 {
    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.bind(new InetSocketAddress(8080));
            logger.info("Server is listening on port 8080");

            while (true) {
                SocketChannel clientChannel = serverChannel.accept();
                logger.info("Accepted connection from: " + clientChannel.socket().getRemoteSocketAddress());

                // Perform security-sensitive operations related to A08_IntegrityFailure
                // Here we use the Java Cryptography Architecture for demonstration purposes
                clientChannel.configureBlocking(false);
                clientChannel.write(java.nio.charmaster.StandardCharsets.UTF_8.encode("IntegrityFailure Message\n"));

                clientChannel.close();
            }
        } catch (IOException e) {
            logger.severe("Error handling client connection: " + e.toString());
        }
    }
}