import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class java_18547_SocketServer_A08 {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    public void init() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void start() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        selector.select();
                        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();
                            iterator.remove();
                            handleKey(key);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void handleKey(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            clientSocketChannel.configureBlocking(false);
            clientSocketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } else if (key.isReadable()) {
            SocketChannel clientSocketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = readBuffer;
            clientSocketChannel.read(buffer);
            // Process the data from the client here
        } else if (key.isWritable()) {
            SocketChannel clientSocketChannel = (SocketChannel) key.channel();
            clientSocketChannel.write(writeBuffer);
            // Send a response back to the client here
        }
    }

    public void stop() throws IOException {
        serverSocketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.init();
        server.start();
    }
}