import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_20312_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        while (true) {
            SocketChannel clientChannel = serverSocketChannel.accept();
            if (clientChannel != null) {
                clientChannel.configureBlocking(false);

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (clientChannel.read(buffer) != -1) {
                    // process the received data
                    processData(buffer);
                    // clear the buffer
                    buffer.clear();
                }

                clientChannel.close();
            }
        }
    }

    private static void processData(ByteBuffer buffer) {
        // TODO: implement the data processing here
        // you may use a library or framework here
    }
}