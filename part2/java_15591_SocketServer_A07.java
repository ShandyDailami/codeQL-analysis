import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class java_15591_SocketServer_A07 {
    private static final int BUFSIZE = 1024;
    private ServerSocketChannel ssc;
    private Selector selector;

    public java_15591_SocketServer_A07(int port) throws IOException {
        ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);
        selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void handleEvents() throws IOException {
        selector.select();
        Iterator<SelectionKey> it = selector.selectedKeys().iterator();
        while (it.hasNext()) {
            SelectionKey key = it.next();
            it.remove();
            if (key.isAcceptable()) {
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(BUFSIZE));
            } else if (key.isReadable()) {
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer buf = (ByteBuffer) key.attachment();
                sc.read(buf);
                // Now you can process your received data...
            }
        }
    }

    public static void main(String[] args) {
        try {
            new SocketServer(9999);
            while (true) {
                new SocketServer(9999).handleEvents();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}