import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class java_16268_SocketServer_A08 {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8888;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocketChannel.accept(selector);

        Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
        while (selectionKeys.hasNext()) {
            SelectionKey key = selectionKeys.next();
            selector.selectedKeys().remove(key);

            if (key.isAcceptable()) {
                ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = serverSocketChannel1.accept();
                socketChannel.configureBlocking(false);
                socketChannel.write(ByteBuffer.wrap("Hello, Client!".getBytes()));
                socketChannel.read(ByteBuffer.allocate(BUFFER_SIZE));
            } else if (key.isReadable()) {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
                socketChannel.read(buffer);
                System.out.println("Received data: " + new String(buffer.array()));
            }
        }
    }
}