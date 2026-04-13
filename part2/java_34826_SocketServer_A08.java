import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_34826_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(12345));
            serverSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);

            System.out.println("Server is listening on port 12345");

            while (true) {
                SocketChannel clientSocketChannel = serverSocketChannel.accept();
                clientSocketChannel.configureBlocking(false);

                System.out.println("Accepted connection from: " + clientSocketChannel.socket().getRemoteSocketAddress());

                // Here you can add your security-sensitive operations related to A08_IntegrityFailure.
            }
        } catch (SocketException e) {
            System.err.println("Could not open an socket!");
        }
    }
}