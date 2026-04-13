import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_17603_SocketServer_A03 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        int port = 12345;
        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            logger.info("Server is listening on port: " + port);

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    logger.info("A client connected!");
                    new Handler(socketChannel).start();
                }
            }
        } catch (IOException e) {
            logger.severe("Failed to listen on port: " + port);
            e.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                if (serverSocketChannel != null)
                    serverSocketChannel.close();
            } catch (IOException e) {
                logger.severe("Failed to close the server socket");
            }
        }
    }
}