import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class java_14704_SocketServer_A08 {
    private final int port;
    private ServerSocketChannel ssc;
    private Selector selector;
    private int maxFd;
    private ByteBuffer[] buffers;

    public java_14704_SocketServer_A08(int port) {
        this.port = port;
        init();
    }

    private void init() {
        try {
            ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(port));
            ssc.configureBlocking(false);

            maxFd = ssc.validOps().stream().map(op -> op.fd()).max().orElse(0) + 1;
            selector = Selector.open(maxFd);
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            buffers = new ByteBuffer[maxFd];
            for (int i = 0; i < maxFd; i++) {
                buffers[i] = ByteBuffer.allocate(1024);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while (true) {
                selector.select();
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    keys.remove();

                    if (key.channel() == ssc && key.isAcceptable()) {
                        handleAccept(key);
                    } else if (key.channel() instanceof SocketChannel && key.isReadable()) {
                        handleRead((SocketChannel) key.channel());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssc.accept();
        sc.configureBlocking(false);

        maxFd = Math.max(maxFd, sc.validOps().stream().map(op -> op.fd()).max().orElse(0) + 1);
        ssc.register(selector, SelectionKey.OP_READ, sc);

        buffers[sc.hashCode()] = ByteBuffer.allocate(1024);
    }

    private void handleRead(SocketChannel sc) throws IOException {
        int r = sc.read(buffers[sc.hashCode()]);
        if (r < 0) {
            sc.close();
            maxFd = Math.max(maxFd, sc.validOps().stream().map(op -> op.fd()).max().orElse(0) + 1);
            sc.key().channel().close();
        } else if (r == 0) {
            sc.close();
            maxFd = Math.max(maxFd, sc.validOps().stream().map(op -> op.fd()).max().orElse(0) + 1);
            sc.key().channel().close();
        } else {
            // Process the request
        }
    }

    public static void main(String[] args) {
        SimpleHTTPServer server = new SimpleHTTPServer(8080);
        server.start();
    }
}