import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class java_39166_SocketServer_A01 {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 5000;
    private static final String ALLOWED_CLIENT_IP = "127.0.0.1";
    private static final List<SocketChannel> clientChannels = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening for client connections on port " + SERVER_PORT);

        while (true) {
            SocketChannel clientChannel = serverSocketChannel.accept();
            if (clientChannel != null) {
                clientChannels.add(clientChannel);
                System.out.println("New client connected from " + clientChannel.socket().getRemoteSocketAddress());
            }

            // Check if there are any clients that should be allowed to connect
            for (SocketChannel channel : clientChannels) {
                if (!channel.isConnected() || !channel.getRemoteAddress().equals(ALLOWED_CLIENT_IP)) {
                    System.out.println("Closing connection to " + channel.socket().getRemoteSocketAddress());
                    channel.close();
                    clientChannels.remove(channel);
                }
            }
        }
    }
}