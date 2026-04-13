import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class java_38557_SocketServer_A03 {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean running = true;

    public java_38557_SocketServer_A03(int port) {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.accept(selector);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        while (running) {
            try {
                int readyChannels = selector.select();
                if (readyChannels == 0) continue;
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        accept(key);
                    } else if (key.isReadable()) {
                        read(key);
                    } else if (key.isWritable()) {
                        write(key);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) {
        // You should implement read logic here
    }

    private void write(SelectionKey key) {
        // You should implement write logic here
    }

    public static void main(String[] args) {
        new SecureSocketServer(8080);
        new Thread(() -> {
            new SecureSocketServer(8081).listen();
        }).start();
    }
}