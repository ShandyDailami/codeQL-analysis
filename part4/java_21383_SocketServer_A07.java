import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_21383_SocketServer_A07 {

    private static final int PORT = 8080;
    private static final int N_THREADS = 10;

    public static void main(String[] args) throws IOException {
        // Create a thread pool with 10 threads
        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);

        // Create a server socket channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // Bind the server socket to a port
        serverSocketChannel.bind(PORT);

        // Listen for incoming connections
        serverSocketChannel.listen(5);

        System.out.println("Server listening on port " + PORT);

        while (true) {
            // Accept incoming connections
            SocketChannel socketChannel = serverSocketChannel.accept();

            // If a connection was successfully accepted, create a new thread to handle the connection
            if (socketChannel != null) {
                executorService.submit(new SocketHandler(socketChannel));
            }
        }
    }
}

class SocketHandler implements Runnable {

    private final SocketChannel socketChannel;

    public java_21383_SocketServer_A07(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        // Handle the connection
        // You can add your own code here
        System.out.println("New connection accepted from " + socketChannel);
    }
}