import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class java_06615_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("A client connected!");

                // Receive data from the client
                byte[] bytes = new byte[1024];
                socketChannel.read(java.nio.Buffer.wrap(bytes));

                // Send data back to the client
                String response = "Hello, client!";
                socketChannel.write(java.nio.Buffer.wrap(response.getBytes(StandardCharsets.UTF_8)));
            }
        }
    }
}