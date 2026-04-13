import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class java_20853_SocketServer_A03 {
    private Selector selector;
    private ServerSocketChannel serverSocket;
    private int port;

    public java_20853_SocketServer_A03(int port) throws IOException {
        this.port = port;
        serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(port));
        serverSocket.configureBlocking(false);

        selector = Selector.open();
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws IOException {
        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        sc.read(buffer);
                        byte[] bytes = buffer.array();
                        String request = new String(bytes, "UTF-8");
                        System.out.println("Received: " + request);
                        // Here you can add more code related to A03_Injection
                    // ...
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(8080).listen();
    }
}