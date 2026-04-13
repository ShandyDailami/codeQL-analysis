import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_25434_SocketServer_A03 {

    private static final int THREADS = 10;
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Create an executor with 10 threads
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        // Create a server socket channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server started on port " + PORT);

        while (true) {
            // Accept a client connection
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                // Create a new thread for each client connection
                executor.execute(new ClientHandler(clientSocketChannel));
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private final SocketChannel clientSocketChannel;

        public java_25434_SocketServer_A03(SocketChannel clientSocketChannel) {
            this.clientSocketChannel = clientSocketChannel;
        }

        @Override
        public void run() {
            // Handle the client connection here
            // For example, close the client connection after a while
            try {
                Thread.sleep(60000); // wait for 60 seconds
                clientSocketChannel.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}