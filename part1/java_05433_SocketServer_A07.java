import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_05433_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);

            System.out.println("Server is listening on port 8080");

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    System.out.println("New connection accepted: " + socketChannel.socket().getRemoteSocketAddress());
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while (socketChannel.isConnected() && socketChannel.read(buffer) != -1) {
                        // process the received data
                        System.out.println("Received: " + new String(buffer.array()));
                        buffer.clear();
                    }
                    socketChannel.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}