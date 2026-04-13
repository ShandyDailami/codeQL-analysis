import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.UUID;

public class java_09488_SocketServer_A07 {
    private static final String AUTH_USER = "admin";
    private static final String AUTH_PASS = "password";

    public static void main(String[] args) throws IOException {
        // Create a ServerSocketChannel to accept client connections
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening for connections...");

        while (true) {
            // Accept a client connection
            SocketChannel socketChannel = serverSocketChannel.accept();

            if (socketChannel == null) {
                // No client connected
                continue;
            }

            // Authenticate the client
            String clientAuth = socketChannel.toString().split(":")[1];

            if (!authenticate(clientAuth)) {
                // Authentication failed
                socketChannel.close();
                System.out.println("Authentication failed, connection closed.");
                continue;
            }

            System.out.println("Client connected: " + socketChannel.getRemoteAddress());

            // Handle the client connection
            // ...

            // Close the client connection
            socketChannel.close();
        }
    }

    private static boolean authenticate(String auth) {
        String[] authParts = auth.split(":");
        String clientAuth = authParts[1];

        return clientAuth.equals(AUTH_USER) && clientAuth.equals(AUTH_PASS);
    }
}