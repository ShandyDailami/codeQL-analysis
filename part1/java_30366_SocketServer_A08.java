import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class java_30366_SocketServer_A08 {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    public void init() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        selectionKey.attach(new Acceptor());
    }

    public void bind(int port) throws IOException {
        serverSocketChannel.bind(new InetSocketAddress(port));
    }

    public void listen() throws IOException {
        selector.select();
        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
        while (iterator.hasNext()) {
            SelectionKey key = iterator.next();
            iterator.remove();
            handleInput(key);
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
            selectionKey.attach(new Acceptor());
        } else if (key.isReadable()) {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            readBuffer.clear();
            socketChannel.read(readBuffer);
            // Here you can add code to handle the received data, such as processing it or responding to it.
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServerExample serverExample = new SocketServerExample();
        serverExample.init();
        serverExample.bind(8080);
        serverExample.selector = Selector.open();
        serverExample.start();
    }

    public void start() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    serverExample.listen();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}