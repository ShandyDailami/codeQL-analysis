import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_27242_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(1234));
            serverSocketChannel.configureBlocking(false);

            logger.log(Level.INFO, "Server is listening on port 1234");

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel == null) {
                    Thread.sleep(1000);
                    continue;
                }

                socketChannel.configureBlocking(false);

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (socketChannel.read(buffer) != -1) {
                    buffer.flip();
                    socketChannel.write(buffer);
                    buffer.clear();
                }

                socketChannel.close();
            }
        } catch (IOException | InterruptedException ex) {
            logger.log(Level.SEVERE, "Error occurred", ex);
        }
    }
}