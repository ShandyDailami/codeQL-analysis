import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_36334_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8080);
        serverSocketChannel.bind(address);
        serverSocketChannel.listen(5);

        System.out.println("Server is listening on port 8080");

        SocketChannel clientChannel = serverSocketChannel.accept();
        System.out.println("A client is connected: " + clientChannel.socket().getRemoteSocketAddress());

        clientChannel.configureBlocking(false);

        // Process the client message here, e.g., read from client, send to client, etc.

        clientChannel.close();
        serverSocketChannel.close();
    }
}