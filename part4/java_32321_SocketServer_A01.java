import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_32321_SocketServer_A01 {
    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        logger.info("Server started on port 8080");

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                clientSocketChannel.configureBlocking(false);

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (clientSocketChannel.read(buffer) != -1) {
                    // Decrypt data here
                    // This is a basic example of decryption
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        byte b = buffer.get();
                        // Decrypt the byte here
                        buffer.put(b ^ 16); // XOR with a byte (e.g., 16)
                    }
                    buffer.flip();

                    // Send data back to client
                    clientSocketChannel.write(buffer);
                    buffer.clear();
                }
                clientSocketChannel.close();
            }
        }
    }
}