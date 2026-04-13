import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_39872_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8080);

        // Bind the server socket to the specified address and port.
        serverSocketChannel.bind(address);

        // Accept a new connection.
        SocketChannel clientChannel = serverSocketChannel.accept();

        // Use a secure channel for communication.
        clientChannel.configureBlocking(false);

        // Close the client channel.
        clientChannel.close();

        // Close the server socket channel.
        serverSocketChannel.close();
    }
}