import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_14297_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening for connections on port 8080");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("New connection accepted from " + socketChannel.socket().getRemoteSocketAddress());
                socketChannel.configureBlocking(false);

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (socketChannel.read(buffer) != -1) {
                    System.out.println("Received: " + buffer.position() + " bytes");
                    // TODO: Process received data

                    buffer.clear();
                }

                socketChannel.close();
            }
        }
    }
}