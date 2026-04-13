import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_40618_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("New connection from " + socketChannel.getRemoteAddress());

                // Process the incoming request
                // This is a simplistic example and is not secure against all types of attacks
                // In a real-world application, you would need to implement security measures such as SSL/TLS, authentication, authorization, and more
                socketChannel.configureBlocking(false);

                // Receive data from the client
                byte[] bytes = new byte[1024];
                socketChannel.read(java.nio.buffer.ByteBuffer.wrap(bytes));

                // Send data to the client
                socketChannel.write(java.nio.buffer.ByteBuffer.wrap("Hello, client!".getBytes()));
            }
        }
    }
}