import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_06636_SocketServer_A01 {
    public static void main(String[] args) {
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            // Set the port for the server to listen on
            serverChannel.bind(new InetSocketAddress(8080));

            while (true) {
                SocketChannel clientChannel = serverChannel.accept();
                System.out.println("Accepted connection from: " + clientChannel.socket().getRemoteSocketAddress());

                // Here you should perform all security-sensitive operations related to A01_BrokenAccessControl
                // For now, we'll just print the remote socket address
                System.out.println("Remote Socket Address: " + clientChannel.socket().getRemoteSocketAddress());

                clientChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}