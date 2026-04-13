import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_17792_SocketServer_A08 {
    private final int port;
    private final ExecutorService executor;

    public java_17792_SocketServer_A08(int port) {
        this.port = port;
        this.executor = Executors.newFixedThreadPool(10);
    }

    public void start() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port " + port);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                executor.execute(new SocketHandler(socketChannel));
            }
        }
    }

    private static class SocketHandler implements Runnable {
        private final SocketChannel socketChannel;

        public java_17792_SocketServer_A08(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            // handle socket connection here...
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(8080).start();
    }
}