import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_07118_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        try {
            // Create a server socket channel and bind it to a port
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));

            logger.log(Level.INFO, "Server is listening for connections...");

            while (true) {
                // Wait for a client to connect
                SocketChannel clientSocketChannel = serverSocketChannel.accept();
                logger.log(Level.INFO, "Client connected from: " + clientSocketChannel.socket().getRemoteSocketAddress());

                // Create a buffer for incoming data
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                // Read data from the client
                while (clientSocketChannel.isConnected() && clientSocketChannel.read(buffer) != -1) {
                    logger.log(Level.INFO, "Received: " + new String(buffer.array()));

                    // Send data back to the client
                    buffer.flip();
                    clientSocketChannel.write(buffer);

                    // Clear the buffer
                    buffer.clear();
                }

                // Close the client socket channel
                clientSocketChannel.close();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IOException occurred: ", ex);
        }
    }
}