import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class java_17167_SocketServer_A01 {

    private static final int BUFSIZE = 1024;
    private ByteBuffer readBuf = ByteBuffer.allocate(BUFSIZE);
    private ByteBuffer writeBuf = ByteBuffer.allocate(BUFSIZE);

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.startServer(6000);
    }

    public void startServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server started on port " + port);

        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;

            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                if (key.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    socketChannel.configureBlocking(false);
                    Selector newSelector = Selector.open();
                    socketChannel.register(newSelector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                } else if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    read(socketChannel);
                } else if (key.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    write(socketChannel);
                }
            }
        }
    }

    private void read(SocketChannel socketChannel) throws IOException {
        socketChannel.read(readBuf);
        byte[] bytes = new byte[readBuf.position()];
        readBuf.flip();
        readBuf.get(bytes, 0, readBuf.limit());
        System.out.println("Read: " + new String(bytes));
        readBuf.clear();
    }

    private void write(SocketChannel socketChannel) throws IOException {
        writeBuf.put("Hello Client".getBytes());
        writeBuf.flip();
        socketChannel.write(writeBuf);
        writeBuf.clear();
    }
}