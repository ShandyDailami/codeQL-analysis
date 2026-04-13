import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class java_01687_SocketServer_A08 {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean running = true;

    public java_01687_SocketServer_A08(int port) throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.accept(selector).channel().setInterestOps(SelectionKey.interestOps() | SelectionKey.OP_ACCEPT);
    }

    public void listen() throws IOException {
        while (running) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = serverChannel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                } else if (key.isReadable()) {
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    clientChannel.read(buffer);
                    System.out.println(new String(buffer.array(), 0, buffer.position()));
                }
            }
        }
    }

    public void close() throws IOException {
        running = false;
        serverSocketChannel.close();
        selector.close();
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8189);
        new Thread(server::listen).start();
        // Server will listen for connections and print received data
    }
}