import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class java_32480_SocketServer_A08 {
    private final int port = 12345;
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    public void init() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        selector = Selector.open();
        serverSocketChannel.accept(selector);
    }

    public void run() throws IOException {
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                if (key.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel channel = ssc.accept();
                    channel.configureBlocking(false);

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.write(buffer);
                    channel.register(selector, SelectionKey.OP_READ);

                } else if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    // handle read operation here

                } else if (key.isWritable()) {
                    // handle write operation here
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.init();
        server.run();
    }
}