import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_10352_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(9876));
            serverSocketChannel.configureBlocking(false);

            // Step 2: Accept incoming connections
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);

            // Step 3: Check if the server is secure
            boolean isSecure = socketChannel.socket().getLocalPort() > 1024;

            // Step 4: Print the result
            System.out.println("Server is " + (isSecure ? "secure" : "not secure"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}