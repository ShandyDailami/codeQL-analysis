import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_12941_SocketServer_A07 {

    private static final Logger LOGGER = Logger.getLogger(VanillaSocketServer.class.getName());

    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(host, port));
            serverSocketChannel.configureBlocking(false);

            LOGGER.info("Server is listening on " + host + ":" + port);

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    socketChannel.configureBlocking(false);

                    // Send a hello message
                    socketChannel.write(("Hello, World!").getBytes());
                    socketChannel.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}