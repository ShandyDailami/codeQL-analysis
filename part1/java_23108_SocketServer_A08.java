import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_23108_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is running on port 8080. Waiting for client connections...");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("A client has connected!");
                socketChannel.configureBlocking(false);

                // Perform security-sensitive operations here
                // For example, verifying the integrity of the message

                // Close the socket channel here
                socketChannel.close();
            }
        }
    }
}