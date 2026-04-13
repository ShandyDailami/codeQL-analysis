import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

public class java_21649_SocketServer_A03 {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public java_21649_SocketServer_A03(int port) throws IOException {
        this.selector = Selector.open();
        this.serverSocketChannel = ServerSocketChannel.open();
        this.serverSocketChannel.bind(new InetSocketAddress(port));
        this.serverSocketChannel.configureBlocking(false);
        SelectionKey selectionKey = this.serverSocketChannel.accept().register(this.selector, SelectionKey.OP_ACCEPT);
        selectionKey.attach(new Acceptor());
    }

    public void run() throws IOException {
        this.selector.select();
        Iterator iterator = this.selector.selectedKeys().iterator();
        while (iterator.hasNext()) {
            SelectionKey selectionKey = (SelectionKey) iterator.next();
            iterator.remove();
            Handler handler = (Handler) selectionKey.attachment();
            handler.run();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8080);
        server.run();
    }

    private class Acceptor implements Runnable {
        public void run() {
            try {
                ServerSocketChannel server = SocketServer.this.serverSocketChannel;
                SelectionKey key = server.accept().accept();
                key.attach(new Handler(key));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class Handler implements Runnable {
        private SelectionKey key;

        public java_21649_SocketServer_A03(SelectionKey key) {
            this.key = key;
        }

        public void run() {
            // handle the client connection
        }
    }
}