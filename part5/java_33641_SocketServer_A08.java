import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_33641_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        // Create an executor for handling multiple requests concurrently.
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);

            System.out.println("Server is listening on port " + PORT);

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    System.out.println("New connection accepted from " + socketChannel.socket().getRemoteSocketAddress());
                    executorService.execute(new SocketHandler(socketChannel));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}

class SocketHandler implements Runnable {
    private SocketChannel socketChannel;

    public java_33641_SocketServer_A08(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            // SocketHandler reads data from the socket and writes the data to the socket.
            // Here, the integrity of data is not guaranteed and the server is not fully secure.
            // For simplicity, we're just echoing back the data.
            byte[] buffer = new byte[1024];
            while ((socketChannel.read(buffer)) != -1) {
                socketChannel.write(buffer);
            }

            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}