import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class java_33513_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(StandardServer.getLocalAddress());
        serverChannel.configureBlocking(false);

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            if (clientChannel != null) {
                handleClient(clientChannel);
            }
        }
    }

    private static void handleClient(SocketChannel clientChannel) throws IOException {
        // ... handle client connection, read messages, etc.
    }
}