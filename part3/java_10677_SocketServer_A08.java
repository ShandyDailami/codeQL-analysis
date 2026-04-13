import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_10677_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a server socket channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // Set the server socket to bind to a specific port (e.g., 8080)
        InetSocketAddress socketAddress = new InetSocketAddress(8080);
        serverSocketChannel.bind(socketAddress);

        System.out.println("Server is listening on port 8080");

        // Create an infinite loop to keep the server running
        while (true) {
            // Accept a new client connection
            SocketChannel clientSocketChannel = serverSocketChannel.accept();

            // Handle the client connection (e.g., by sending and receiving messages)
            // You can use a separate thread to handle each client connection
            new Thread(() -> {
                // TODO: handle client connection
            }).start();
        }
    }
}