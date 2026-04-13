import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_42011_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080");

        while (true) {
            // Accept a client connection
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel == null) {
                continue;
            }

            clientSocketChannel.configureBlocking(false);

            // Read a message from the client
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = clientSocketChannel.read(buffer);
            if (bytesRead == -1) {
                clientSocketChannel.close();
                continue;
            }

            // Check for integrity failure
            if (checkIntegrity(buffer)) {
                System.out.println("Integrity failure detected, closing connection");
                clientSocketChannel.close();
                continue;
            }

            // Write a message to the client
            buffer.flip();
            clientSocketChannel.write(buffer);
       
            // Close the connection
            clientSocketChannel.close();
        }
    }

    private static boolean checkIntegrity(ByteBuffer buffer) {
        // This is a placeholder. In a real-world scenario, you would perform a checksum or similar integrity check on the data in the buffer.
        // For simplicity, we'll just check if the data is all zeros.
        for (int i = 0; i < buffer.limit(); i++) {
            if (buffer.get(i) != 0) {
                return true;
            }
        }
        return false;
    }
}