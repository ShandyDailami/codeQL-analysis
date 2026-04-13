import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_09793_SocketServer_A03 {

    private static final Logger LOGGER = Logger.getLogger(SecureServer.class.getName());

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                LOGGER.info("Accepted connection from: " + socketChannel.socket().getRemoteSocketAddress());
                handleRequest(socketChannel);
            }
        }
    }

    private static void handleRequest(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = socketChannel.read(buffer).toString()) != null) {
            response.append(line);
        }

        String request = response.toString();
        if (request.contains("Password")) {
            // handle injection attempt here, e.g., logging or blocking
            LOGGER.info("Detected injection attempt: " + request);
            // e.g., block client, otherwise accept connection
            socketChannel.close();
        } else {
            // send response
            String responseMessage = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/plain; charset=UTF-8\r\n\r\n" +
                    "Thank you for connecting to " + socketChannel.socket().getRemoteSocketAddress() + "\r\n";
            socketChannel.write(ByteBuffer.wrap(responseMessage.getBytes()));
        }

        socketChannel.close();
    }
}