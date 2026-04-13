import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_30276_SocketServer_A03 {

    private static final int THREAD_COUNT = 10; // Number of threads for handling connections

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server started, listening on port 8080");

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                executor.execute(new SocketHandler(clientSocketChannel));
            }
        }
    }

    static class SocketHandler implements Runnable {
        SocketChannel clientSocketChannel;

        public java_30276_SocketServer_A03(SocketChannel clientSocketChannel) {
            this.clientSocketChannel = clientSocketChannel;
        }

        @Override
        public void run() {
            // Handle the client connection here
            // You can start a new thread to handle the communication with the client
        }
    }
}