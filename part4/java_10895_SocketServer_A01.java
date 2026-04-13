import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_10895_SocketServer_A01 {

    private static final Logger logger = Logger.getLogger(SecureServer.class.getName());

    public static void main(String[] args) {
        int port = 8080;
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.bind(new java.net.InetSocketAddress(port));
            ssc.configureBlocking(false);
            logger.log(Level.INFO, "Server started on port: {0}", port);

            while (true) {
                SocketChannel sc = ssc.accept();
                if (sc == null)
                    continue;
                sc.configureBlocking(false);

                ByteBuffer buf = ByteBuffer.allocate(1024);
                while (sc.read(buf) != -1) {
                    buf.flip();
                    // Handle the received data
                    String received = new String(buf.array(), 0, buf.position());
                    logger.log(Level.INFO, "Received: {0}", received);
                    buf.clear();
                }

                sc.close();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Exception caught when trying to listen on port {0}", port);
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            System.exit(1);
        } finally {
            try {
                ssc.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
}