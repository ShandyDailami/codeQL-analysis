import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_16138_SocketServer_A03 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        new SocketServer().start();
    }

    private void start() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try (SocketChannel channel = SocketChannel.open()) {
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress(8080));
            logger.info("Server is waiting for connections...");
            while (true) {
                SocketChannel clientChannel = channel.accept();
                if (clientChannel != null) {
                    logger.info("A client has connected");
                    clientChannel.configureBlocking(false);
                    while (clientChannel.isConnected()) {
                        int bytesRead = clientChannel.read(buffer).compareTo(0);
                        if (bytesRead > 0) {
                            logger.info("Received message: " + buffer.flip().slice().asReadOnlyBuffer());
                            buffer.clear();
                        } else if (bytesRead < 0) {
                            logger.info("Closed connection from " + clientChannel);
                            clientChannel.close();
                            break;
                        }
                    }
                }
            }
        } catch (IOException ex) {
            logger.severe("I/O exception: " + ex);
        }
    }
}