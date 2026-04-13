import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_02433_SocketServer_A01 {

    private static final Logger logger = Logger.getLogger(SecureEchoServer.class.getName());

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);

        logger.info("Server started on port " + port);

        while (true) {
            SocketChannel sc = ssc.accept();
            if (sc == null) continue;

            sc.configureBlocking(false);

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (sc.read(buffer) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    sc.write(buffer);
                }
                buffer.clear();
            }

            sc.close();
        }
    }
}