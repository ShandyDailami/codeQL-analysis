import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_35711_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        int port = 8080;
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(port));
            ssc.configureBlocking(false);
            logger.info("Server is listening on port: " + port);

            while (true) {
                SocketChannel sc = ssc.accept();
                if (sc != null) {
                    sc.configureBlocking(false);
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    while (sc.read(buf) != -1) {
                        buf.flip();
                        // Process incoming data here.
                        logger.info(new String(buf.array(), 0, buf.position()));
                        buf.clear();
                    }
                    sc.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ssc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}