import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_41440_SocketServer_A03 {

    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(org.openjdk.nio.fs.Files.newFileIntStream(1, 1, org.openjdk.nio.file.StandardOpenOption.WRITE));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.keyFor(SelectionKey.OP_ACCEPT).channel().register(serverSocketChannel, SelectionKey.OP_ACCEPT);

        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

        while (true) {
            SelectionKey key = serverSocketChannel.select().iterator().next();

            if (key.isAcceptable()) {
                ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                SocketChannel clientChannel = serverChannel.accept();
                clientChannel.configureBlocking(false);
                clientChannel.register(serverSocketChannel, SelectionKey.OP_READ);
            } else if (key.isReadable()) {
                SocketChannel clientChannel = (SocketChannel) key.channel();
                buffer.clear();
                clientChannel.read(buffer);
                System.out.println("Received: " + new String(buffer.array()));
            }
        }
    }
}