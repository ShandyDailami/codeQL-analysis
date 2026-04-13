import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_00353_SocketServer_A03 {

    private static final String SERVER_MESSAGE = "Server listening...";

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);

        System.out.println("Server is listening...");

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            if (clientChannel != null) {
                System.out.println("New client connected from " + clientChannel);
                clientChannel.configureBlocking(false);

                ByteBuffer buffer = ByteBuffer.allocate(1024);

                while (clientChannel.read(buffer) != -1) {
                    buffer.flip();
                    System.out.println(new String(buffer.array(), "UTF-8"));
                    buffer.clear();
                }

                clientChannel.close();
            }
        }
    }
}