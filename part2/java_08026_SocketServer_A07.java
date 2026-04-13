import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.UUID;

public class java_08026_SocketServer_A07 {

    private static final String AUTHENTICATED_USER = "authenticated_user";
    private static final String AUTH_FAILURE_PREFIX = "A07_AuthFailure: ";

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server started, waiting for connections...");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                handleConnection(socketChannel);
            }
        }
    }

    private static void handleConnection(SocketChannel socketChannel) throws IOException {
        if (socketChannel != null) {
            String authResult = authenticateUser(socketChannel);
            if (!authResult.startsWith(AUTH_FAILURE_PREFIX)) {
                socketChannel.configureBlocking(false);
                socketChannel.write(ByteBuffer.wrap("Connected as: " + authResult));
            } else {
                socketChannel.close();
            }
        }
    }

    private static String authenticateUser(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        socketChannel.read(buffer);
        String request = new String(buffer.array(), 0, buffer.position());

        if (AUTHENTICATED_USER.equals(request)) {
            return UUID.randomUUID().toString();
        } else {
            return AUTH_FAILURE_PREFIX + "Invalid username or password";
        }
    }
}