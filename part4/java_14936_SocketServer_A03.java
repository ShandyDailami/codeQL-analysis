import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_14936_SocketServer_A03 {
    private final ExecutorService executorService;
    private final ServerSocketChannel serverSocketChannel;

    public java_14936_SocketServer_A03(int port) throws IOException {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
    }

    public void start() throws IOException {
        System.out.println("Server is listening on port " + serverSocketChannel.localAddress().getPort());
        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                executorService.execute(new SocketHandler(clientSocketChannel));
            }
        }
    }

    public void stop() throws IOException {
        serverSocketChannel.close();
        executorService.shutdown();
    }

    private static class SocketHandler implements Runnable {
        private final SocketChannel socketChannel;

        SocketHandler(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            try {
                // TODO: Add your handling code here
            } finally {
                socketChannel.close();
            }
        }
    }
}