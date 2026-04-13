import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_13297_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    private final ServerSocketChannel serverSocketChannel;

    public java_13297_SocketServer_A08(int port) throws Exception {
        ServerSocket socket = new ServerSocket(port);
        serverSocketChannel = ServerSocketChannel.open(socket.getLocalSocketAddress());
        serverSocketChannel.configureBlocking(false);
        logger.info("Server is bound to port: " + port);
    }

    public void start() throws Exception {
        while (!Thread.currentThread().isInterrupted()) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                handleClient(clientSocketChannel);
            }
        }
        serverSocketChannel.close();
    }

    private void handleClient(SocketChannel clientSocketChannel) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (clientSocketChannel.read(buffer) != -1) {
            // Process the received data
            buffer.flip();
            while (buffer.hasRemaining()) {
                // Do something with buffer.get()
            }
            buffer.clear();
        }
        clientSocketChannel.close();
    }

    public static void main(String[] args) {
        try {
            new SecureSocketServer(8080).start();
        } catch (Exception e) {
            logger.severe("Failed to start server: " + e.getMessage());
        }
    }
}