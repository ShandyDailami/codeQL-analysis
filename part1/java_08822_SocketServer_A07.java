import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.UUID;

public class java_08822_SocketServer_A07 {
    private static final int DEFAULT_PORT = 12345;

    public static void main(String[] args) throws IOException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port " + port);

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel == null) {
                continue;
            }

            // Authenticate client
            String authToken = UUID.randomUUID().toString();
            clientSocketChannel.write(ByteBuffer.wrap(authToken.getBytes()));

            // Read and validate authentication
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            clientSocketChannel.read(buffer);
            String receivedAuthToken = new String(buffer.array(), 0, buffer.position());

            if (!receivedAuthToken.equals(authToken)) {
                System.out.println("Authentication failed for client");
                continue;
            }

            // Client is authenticated, start communication with client
            System.out.println("Client is authenticated, starting communication with client");

            // TODO: Implement real communication with client here

            clientSocketChannel.close();
        }
    }
}