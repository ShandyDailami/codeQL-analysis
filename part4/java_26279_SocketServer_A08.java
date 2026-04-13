import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_26279_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        int port = 8080;
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(port));
            ssc.configureBlocking(false);

            logger.log(Level.INFO, "Server is listening on port {0}", port);

            while (true) {
                SocketChannel sc = ssc.accept();
                if (sc == null) {
                    continue;
                }
                sc.configureBlocking(false);

                // Process the connection
                new Thread(() -> handleConnection(sc)).start();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error occurred while binding port {0}", port, ex);
        } finally {
            if (ssc != null) {
                try {
                    ssc.close();
                } catch (IOException ex) {
                    logger.log(Level.SEVERE, "Error occurred while closing the server", ex);
                }
            }
        }
    }

    private static void handleConnection(SocketChannel sc) {
        if (sc.isConnected()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String response = "Hello, you connected to the server!";
            try {
                // Write the response
                buffer.put(response.getBytes());
                buffer.flip();
                while (buffer.hasRemaining()) {
                    sc.write(buffer);
                }
                sc.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Error occurred while processing the connection", ex);
            }
        }
    }
}