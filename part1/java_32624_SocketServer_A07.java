import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class java_32624_SocketServer_A07 {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public java_32624_SocketServer_A07(int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws IOException {
        System.out.println("Server listening on port " + serverSocketChannel.getLocalAddress().getPort());

        while (true) {
            selector.select();
            for (SelectionKey key : selector.selectedKeys()) {
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = server.accept();
                    clientChannel.configureBlocking(false);

                    // Handle client connection
                    new ClientHandler(clientChannel, selector).start();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(8080).listen();
    }
}