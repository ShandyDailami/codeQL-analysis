import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_31568_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and bind it to port 1234
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(1234));

        // Create a buffer for receiving data from the client
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            // Wait for a client to connect
            SocketChannel clientSocketChannel = serverSocketChannel.accept();

            // Send a welcome message to the client
            String welcomeMessage = "Welcome to the server!";
            buffer.put((welcomeMessage + "\n").getBytes());
            buffer.flip();
            clientSocketChannel.write(buffer);

            // Receive data from the client
            while (clientSocketChannel.read(buffer) != -1) {
                buffer.flip();
                System.out.println(new String(buffer.array()));
                buffer.clear();
           
            }

            // Close the client socket channel
            clientSocketChannel.close();
        }
    }
}