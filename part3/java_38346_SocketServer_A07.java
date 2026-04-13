import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class java_38346_SocketServer_A07 {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final int BUFFER_SIZE = 1024;
    private ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER_SIZE);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(BUFFER_SIZE);

    public java_38346_SocketServer_A07(int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        selector = Selector.open();
        serverSocketChannel.accept(selector);
    }

    public void start() throws IOException {
        while (true) {
            selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    read(socketChannel);
                } else if (key.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    write(socketChannel);
                }
            }
        }
    }

    private void read(SocketChannel socketChannel) throws IOException {
        // TODO: implement read operation
    }

    private void write(SocketChannel socketChannel) throws IOException {
        // TODO: implement write operation
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8080);
        server.start();
    }
}