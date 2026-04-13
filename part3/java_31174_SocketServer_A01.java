import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_31174_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080");

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                System.out.println("Client connected from " + clientSocketChannel.socket().getRemoteSocketAddress());

                // Perform some security sensitive operations here. For example, enabling SSL for communication.
                // Here, we'll just print a message to the client.
                clientSocketChannel.write(StandardCharsets.UTF_8.encode("Welcome to secure server!"));
            }
        }
    }
}