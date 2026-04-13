import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_01237_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(LegacySocketServer.class.getName());

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        logger.log(Level.INFO, "Server started. Listening on port 8080...");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                socketChannel.configureBlocking(false);

                logger.log(Level.INFO, "Connection accepted from " + socketChannel.socket().getRemoteSocketAddress());

                ByteBuffer input = ByteBuffer.allocate(1024);
                StringBuilder response = new StringBuilder();
                response.append("HTTP/1.1 200 OK\n");
                response.append("Content-Type: text/plain; charset=UTF-8\n");
                response.append("\r\n");

                while (socketChannel.read(input) != -1) {
                    input.flip();
                    response.append(StandardCharsets.UTF_8.decode(input).toString());
                    input.clear();
                }

                socketChannel.write(response.toString().getBytes());
                socketChannel.close();
            }
        }
    }
}