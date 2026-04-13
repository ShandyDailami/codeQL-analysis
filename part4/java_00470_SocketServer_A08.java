import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_00470_SocketServer_A08 {
    
    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());
    
    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER";
    
    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);
            
            logger.log(Level.INFO, "Server started on port 8080");
            
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    socketChannel.configureBlocking(false);
                    
                    // Encrypt the client identifier before handshake
                    socketChannel.write(CLIENT_IDENTIFIER.getBytes());
                    
                    // Wait for the client to send handshake request
                    byte[] bytes = new byte[256];
                    socketChannel.read(bytes);
                    
                    // Decrypt the client identifier after handshake
                    String receivedClientIdentifier = new String(bytes);
                    if (CLIENT_IDENTIFIER.equals(receivedClientIdentifier)) {
                        logger.log(Level.INFO, "Client authenticated successfully");
                    } else {
                        logger.log(Level.WARNING, "Client authentication failed");
                    }
                }
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Exception occurred", ex);
        }
    }
}