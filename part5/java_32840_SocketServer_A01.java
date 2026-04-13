import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_32840_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 8080;
        ServerSocketChannel serverSocketChannel = null;
        SocketChannel clientSocketChannel = null;

        try {
            // Create a server socket channel
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);

            System.out.println("Server is listening on port: " + port);

            while (true) {
                // Accept a client connection
                clientSocketChannel = serverSocketChannel.accept();
                if (clientSocketChannel != null) {
                    System.out.println("New connection accepted from: " + clientSocketChannel.socket().getRemoteSocketAddress());

                    // Sending a welcome message to the client
                    ByteBuffer welcomeBuffer = ByteBuffer.wrap("Welcome to the server".getBytes());
                    clientSocketChannel.write(welcomeBuffer);

                    // Close the client connection
                    clientSocketChannel.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket channel
            if (serverSocketChannel != null) {
                try {
                    serverSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}