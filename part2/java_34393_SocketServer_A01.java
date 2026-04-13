import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_34393_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server started. Listening on port 8080...");

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                System.out.println("Connection established from: " + clientSocketChannel.socket().getRemoteSocketAddress());

                // Send a welcome message to the client
                String response = "Welcome to the server!\n";
                ByteBuffer buffer = ByteBuffer.wrap(response.getBytes());
                clientSocketChannel.write(buffer);

                // Close the connection
                clientSocketChannel.close();
            }
        }
    }
}