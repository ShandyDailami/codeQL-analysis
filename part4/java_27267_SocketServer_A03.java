import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_27267_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is running on port 8080");

        while (true) {

            // Accept a client connection
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                System.out.println("A client is connected");

                // Create a writer to send a response
                PrintWriter writer = new PrintWriter(clientSocketChannel.socket().getOutputStream(), true);

                // Create a buffer to hold data
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                // Read data from the client
                while (clientSocketChannel.read(buffer) != -1) {
                    // Decode the data
                    byte[] data = new byte[buffer.position()];
                    buffer.flip();
                    buffer.get(data);
                    buffer.clear();

                    // Send the data back to the client
                    writer.println("Echo: " + new String(data));
                }

                // Close the connection
                clientSocketChannel.close();
            }
        }
    }
}