import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_34392_SocketServer_A07 {

    private final static int PORT = 8080;

    public static void main(String[] args) {

        // Create a pool of worker threads
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            // Bind the server socket to the port
            serverSocketChannel.bind(new InetSocketAddress(PORT));

            System.out.println("Server is listening on port " + PORT);

            while (true) {

                // Accept incoming connection
                SocketChannel socketChannel = serverSocketChannel.accept();

                // Invoke executor service to handle socket IO
                executorService.execute(new SocketHandler(socketChannel));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Shutdown executor service
            executorService.shutdown();
        }
    }
}

class SocketHandler implements Runnable {

    private final SocketChannel socketChannel;

    public java_34392_SocketServer_A07(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            // Infinite loop to read from the socket
            while (true) {
                socketChannel.write(ByteBuffer.wrap("Hello, Client!".getBytes()));
                socketChannel.read(ByteBuffer.allocate(1024));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the socket channel
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}