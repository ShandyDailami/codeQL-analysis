import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_21865_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(PORT));

            while (true) {
                SocketChannel clientChannel = serverSocketChannel.accept();
                System.out.println("Accepted connection from " + clientChannel.getRemoteAddress());

                // Simulate a security breach by blocking all access
                clientChannel.configureBlocking(true);

                // Simulate a security breach by closing the connection immediately
                clientChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}