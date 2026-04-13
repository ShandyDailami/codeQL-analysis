import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_25229_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                handleClient(clientSocketChannel);
            }
        }
    }

    private static void handleClient(SocketChannel clientSocketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 200 OK\n");
        response.append("Content-Type: text/html; charset=UTF-8\n\n");
        response.append("<html><body>Hello, world!</body></html>\n");
        buffer.put(response.toString().getBytes());
        buffer.flip();
        clientSocketChannel.write(buffer);
        buffer.clear();
        clientSocketChannel.close();
    }
}