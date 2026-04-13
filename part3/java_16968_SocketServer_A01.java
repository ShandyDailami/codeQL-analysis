import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_16968_SocketServer_A01 {

    private final ExecutorService executor;

    public java_16968_SocketServer_A01() {
        executor = Executors.newCachedThreadPool();
    }

    public void start(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server started on port " + port);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                executor.execute(new SocketHandler(socketChannel));
            }
        }
    }

    private static class SocketHandler implements Runnable {
        private final SocketChannel socketChannel;

        public java_16968_SocketServer_A01(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            try {
                while (socketChannel.read(buffer) != -1) {
                    // Process the received message here...
                    System.out.println("Received: " + new String(buffer.array(), 0, buffer.position()));
                    buffer.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            socketChannel.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer().start(1234);
    }
}