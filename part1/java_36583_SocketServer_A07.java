import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.HashSet;
import java.util.Set;

public class java_36583_SocketServer_A07 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String AUTHORIZED_IP = "127.0.0.1"; // Authorized IP

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
        serverChannel.configureBlocking(false);

        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        Set<String> authorizedClients = new HashSet<>();
        authorizedClients.add(AUTHORIZED_IP);

        while (true) {
            selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            for (SelectionKey key : selectedKeys) {
                serverChannel.accept();
                if (key.channel() instanceof ServerSocketChannel) {
                    // New connection, check if the client's IP is authorized
                    String clientIP = key.channel().getRemoteAddress().toString();
                    if (authorizedClients.contains(clientIP)) {
                        // If authorized, start communication
                        key.channel().configureBlocking(false);
                    } else {
                        // If not authorized, close the connection
                        key.channel().close();
                    }
                }
            }
        }
    }
}