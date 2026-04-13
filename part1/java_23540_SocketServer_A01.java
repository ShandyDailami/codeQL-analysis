import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_23540_SocketServer_A01 {

    private static final int PORT = 8080;
    private static final int NTHREADES = 5;

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(NTHREADES);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                executorService.submit(new SocketHandler(socketChannel));
            }
        }
    }

    static class SocketHandler implements Runnable {
        SocketChannel socketChannel;

        SocketHandler(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            // Handle the client connection here
            // For now, just print a message
            System.out.println("Client connected!");
        }
    }
}