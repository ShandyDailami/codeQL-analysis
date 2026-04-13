import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_34869_SocketServer_A03 {
    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);

            System.out.println("Server started on port 8080");

            while (true) {
                SocketChannel clientChannel = serverSocketChannel.accept();
                if (clientChannel != null) {
                    System.out.println("A client connected from " + clientChannel.socket().getRemoteSocketAddress());

                    // Prevent client from connecting
                    clientChannel.configureBlocking(false);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}