import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_23262_SocketServer_A03 {

    private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();

    private final ExecutorService executorService;
    private final ServerSocketChannel serverSocketChannel;

    public java_23262_SocketServer_A03(int port) throws IOException {
        executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
    }

    public void start() {
        System.out.println("Server started on port " + serverSocketChannel.localAddress().getPort());

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                executorService.execute(new SocketHandler(socketChannel));
            }
        }
    }

    public void stop() {
        executorService.shutdown();
        try {
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SocketHandler implements Runnable {
        private final SocketChannel socketChannel;

        public java_23262_SocketServer_A03(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            // Handle the client connection here
            // For simplicity, we just print out the received data
            try {
                byte[] bytes = new byte[1024];
                while (socketChannel.read(BytesBuffer) > 0) {
                    System.out.println(new String(bytes, "UTF-8"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}