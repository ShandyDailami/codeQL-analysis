import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_26928_SocketServer_A01 {

    public static void main(String[] args) {
        new SocketServer().startServer();
    }

    private void startServer() {
        ServerSocketChannel serverSocketChannel = null;
        SocketChannel socketChannel = null;

        try {
            serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress address = new InetSocketAddress(8080);
            serverSocketChannel.bind(address);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    System.out.println("A new connection is accepted from " + socketChannel);
                    handleRequest(socketChannel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocketChannel != null) serverSocketChannel.close();
                if (socketChannel != null) socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleRequest(SocketChannel socketChannel) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 200 OK\r\n");
        response.append("Content-Type: text/html;charset=utf-8\r\n\r\n");

        try {
            while (socketChannel.read(buffer) != -1) {
                buffer.flip();
                response.append(new String(buffer.asBytes()));
                buffer.clear();
            }
            socketChannel.write(response.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}