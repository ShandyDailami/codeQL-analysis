import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_35290_SocketServer_A07 {

    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            // Bind the server socket to a port
            serverSocketChannel.bind(new InetSocketAddress(8080));

            System.out.println("Server is listening on port 8080...");

            while (true) {
                SocketChannel clientSocketChannel = serverSocketChannel.accept();
                System.out.println("New client connected: " + clientSocketChannel.getRemoteAddress());

                // Handle the client connection here
                // ...

                clientSocketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}