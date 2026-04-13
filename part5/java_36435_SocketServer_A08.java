import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_36435_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            if (clientChannel != null) {
                handleClient(clientChannel);
            }
        }
    }

    private static void handleClient(SocketChannel clientChannel) throws IOException {
        // Close the client connection after a response is sent
        clientChannel.configureBlocking(false);

        // Send a welcome message to the client
        String response = "Welcome to the Secure Socket Server!\n";
        clientChannel.write(response.getBytes());

        // Read the response from the client
        byte[] bytes = new byte[1024];
        clientChannel.read(bytes);

        // Close the client connection
        clientChannel.close();
    }
}