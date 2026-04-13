import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class java_19400_SocketServer_A03 {
    private static final int DEFAULT_PORT = 8080;
    private static final int MAX_BUFFER = 1024;

    private int port;
    private ServerSocketChannel ssc;
    private Queue<SocketChannel> queue;

    public java_19400_SocketServer_A03(int port) {
        this.port = port;
        this.ssc = ServerSocketChannel.open();
        this.ssc.bind(new InetSocketAddress(port));
        this.ssc.configureBlocking(false);
        this.queue = new ConcurrentLinkedQueue<>();
    }

    public void start() throws IOException {
        System.out.println("Starting server on port " + port);
        while (true) {
            SocketChannel sc = ssc.accept();
            if (sc != null) {
                System.out.println("New client connected: " + sc.socket().getRemoteSocketAddress());
                sc.configureBlocking(false);
                queue.offer(sc);
            } else {
                // Handle connections here
            }

            // handle client read
            while (true) {
                SocketChannel socketChannel = queue.poll();
                if (socketChannel == null) break;
                ByteBuffer buffer = ByteBuffer.allocate(MAX_BUFFER);
                int bytesRead = socketChannel.read(buffer);
                if (bytesRead == -1) {
                    socketChannel.close();
                    System.out.println("Client disconnected: " + socketChannel.socket().getRemoteSocketAddress());
                } else {
                    // handle received data here
                }
            }
        }
    }

    public void stop() throws IOException {
        ssc.close();
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(DEFAULT_PORT);
        server.start();
    }
}