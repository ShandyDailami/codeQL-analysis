import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_31688_SocketServer_A03 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 4445;

    public static void main(String[] args) throws Exception {
        int port = SERVER_PORT;
        String address = SERVER_ADDRESS;

        // Create a server socket channel
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.bind(new InetSocketAddress(address, port));
            serverChannel.configureBlocking(false);

            System.out.println("Server listening on " + serverChannel.getLocalAddress().toString() + " " + port);

            // Create a new channel to handle incoming connections
            try (SocketChannel clientChannel = serverChannel.accept()) {
                clientChannel.configureBlocking(false);

                System.out.println("Connected to " + clientChannel.getRemoteAddress().toString());

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (clientChannel.read(buffer) != -1) {
                    buffer.flip();

                    // Process the received data here

                    buffer.clear();
                }

                System.out.println("Disconnected from " + clientChannel.getRemoteAddress().toString());
            }
        }
    }
}