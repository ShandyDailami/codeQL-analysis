import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class java_24931_SocketServer_A07 {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final String AUTH_SUCCESS = "Auth successful";
    private static final String AUTH_FAILURE = "Auth failure";

    public java_24931_SocketServer_A07(int port) throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws IOException {
        System.out.println("Server is listening on port " + serverSocketChannel.getLocalAddress().toString().substring(10));
        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel channel = ssc.accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                } else if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    int bytesRead = channel.read(buffer);
                    if (bytesRead == -1) {
                        channel.close();
                        System.out.println("Connection closed by client");
                    } else {
                        String response = new String(buffer.array(), 0, bytesRead);
                        buffer.clear();
                        if (response.startsWith("AUTH")) {
                            // Perform authentication and set response
                            String authResponse = (response.equals("AUTH TEST") ? AUTH_SUCCESS : AUTH_FAILURE);
                            channel.write(ByteBuffer.wrap(authResponse.getBytes()));
                        } else {
                            channel.write(ByteBuffer.wrap("Unknown message".getBytes()));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(8080).listen();
    }
}