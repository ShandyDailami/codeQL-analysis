import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class java_07446_SocketServer_A03 {
    private static final int DEFAULT_PORT = 12345;
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private boolean isStopped;

    public java_07446_SocketServer_A03() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(DEFAULT_PORT));
        serverSocketChannel.configureBlocking(false);

        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void run() {
        System.out.println("Server started on port " + DEFAULT_PORT);

        while (!isStopped) {
            try {
                selector.select();
                for (SelectionKey key : selector.selectedKeys()) {
                    if (key.isAcceptable()) {
                        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                        SocketChannel channel = ssc.accept();
                        channel.configureBlocking(false);

                        // Here you can add your security-sensitive operations for A03_Injection
                        // For instance, you can use SSLContext to encrypt the communication
                        // But for simplicity, we just print a message without encryption

                        System.out.println("New connection from " + channel.getRemoteAddress().toString());
                    }
                }
            } catch (IOException e) {
                if (!isStopped) {
                    e.printStackTrace();
                } else {
                    // closing this thread
                    e.printStackTrace();
                    return;
                }
            }
        }

        try {
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        isStopped = true;
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer().run();
    }
}