import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_22112_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Setup the server socket
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(8080));

        System.out.println("Server is listening for connections on port 8080");

        while (true) {
            // Accept a new connection
            SocketChannel clientSocket = serverSocket.accept();
            System.out.println("New connection accepted from " + clientSocket.socket().getRemoteSocketAddress());

            // Read from the client
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            clientSocket.read(buffer);
            String request = new String(buffer.array(), "UTF-8");
            System.out.println("Received request: " + request);

            // Send a response
            String response = "Hello, client!";
            buffer = ByteBuffer.wrap(response.getBytes("UTF-8"));
            clientSocket.write(buffer);

            // Close the connection
            clientSocket.close();
        }
    }
}