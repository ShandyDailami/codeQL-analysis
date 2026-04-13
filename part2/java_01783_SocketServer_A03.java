import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_01783_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // Bind the server socket to a port
        serverSocketChannel.bind(new InetSocketAddress(8080));

        // Set the server socket to accept incoming connections
        serverSocketChannel.listen(5);

        // Wait for a client to connect
        SocketChannel clientSocketChannel = serverSocketChannel.accept();

        // Read data from the client
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        clientSocketChannel.read(buffer);

        // Process the data
        String data = new String(buffer.array()).trim();
        System.out.println("Received: " + data);

        // Send a response back to the client
        String response = "Hello, Client!";
        clientSocketChannel.write(ByteBuffer.wrap(response.getBytes()));

        // Close the connection
        clientSocketChannel.close();
        serverSocketChannel.close();
    }
}