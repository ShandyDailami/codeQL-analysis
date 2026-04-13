import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class java_01794_SocketServer_A08 {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public java_01794_SocketServer_A08(int port) throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        SelectionKey selectionKey = serverSocketChannel.accept()
                .configureBlocking(false)
                .register(selector, SelectionKey.OP_ACCEPT);

        SelectionKey key = selector.select();
        while (key != null) {
            handleSelectionKey(key);
            key = selector.select();
        }
    }

    private void handleSelectionKey(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel channel = ssc.accept();
            channel.configureBlocking(false);

            // Handle the connection here
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(8080);
    }
}