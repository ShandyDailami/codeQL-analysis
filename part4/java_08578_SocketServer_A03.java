import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_08578_SocketServer_A03 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);

        logger.log(Level.INFO, "Server started on port 8080.");

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            if (clientChannel != null) {
                logger.log(Level.INFO, "Client connected from {0}", clientChannel.socket().getRemoteSocketAddress());
                clientChannel.configureBlocking(false);

                ByteBuffer buf = ByteBuffer.allocate(1024);
                while (clientChannel.read(buf) != -1) {
                    buf.flip();
                    // Perform security sensitive operation here using buf
                    // ...

                    buf.clear();
                }

                clientChannel.close();
            }
        }
    }
}