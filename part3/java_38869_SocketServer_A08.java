import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_38869_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            // Binding to the port
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                SocketChannel clientSocketChannel = serverSocketChannel.accept();
                System.out.println("Client connected");

                // Here you can handle the client connection and perform security-sensitive operations related to A08_IntegrityFailure

                // Close the client socket channel after a few seconds
                clientSocketChannel.closeAfter(5, TimeUnit.SECONDS);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}