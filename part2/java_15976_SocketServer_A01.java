import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_15976_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.setOption(ChannelOption.SO_REUSEADDR, true);
        serverSocketChannel.configureBlocking(false);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                // Perform security-sensitive operations here.
                // For example, verify the client's identity and restrict access to sensitive operations.
                // In this case, we're just logging the client's address.
                System.out.println("Connected to: " + socketChannel.getRemoteAddress());
            }
        }
    }
}