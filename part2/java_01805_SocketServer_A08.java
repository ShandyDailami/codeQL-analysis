import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_01805_SocketServer_A08 {

    private static final String LOCALHOST = "localhost";
    private static final String SERVER_ADDRESS = LOCALHOST + ":" + "12345"; // "localhost:12345"
    private static final int DEFAULT_PORT = 12345;

    public static void main(String[] args) {
        SocketServerExample serverExample = new SocketServerExample();
        serverExample.startServer();
    }

    private void startServer() {
        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress address = new InetSocketAddress(LOCALHOST, DEFAULT_PORT);
            serverSocketChannel.bind(address);
            System.out.println("Server is listening on port " + DEFAULT_PORT);
            while (true) {
                SocketChannel clientSocketChannel = serverSocketChannel.accept();
                System.out.println("New client connected: " + clientSocketChannel.getRemoteAddress());
                clientSocketChannel.configureBlocking(false);
                // Here you can add your server logic, for example to handle incoming client data
                // serverSocketChannel.write(ByteBuffer.wrap("Received data from client".getBytes()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocketChannel != null) serverSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}