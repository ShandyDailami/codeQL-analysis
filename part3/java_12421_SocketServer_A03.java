import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_12421_SocketServer_A03 {
    private static final int PORT = 8080;
    private static final int N_THREADS = 10;

    private final ExecutorService executor;

    public java_12421_SocketServer_A03() {
        executor = Executors.newFixedThreadPool(N_THREADS);
    }

    public void start() {
        try (ServerSocketChannel serverSocket = ServerSocketChannel.open()) {
            serverSocket.bind(PORT);
            serverSocket.setReuseAddress(true);

            System.out.println("Server is listening on port " + PORT);

            while (true) {
                SocketChannel clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteAddress());

                executor.submit(new SocketHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class SocketHandler implements Runnable {
        private final SocketChannel socket;

        public java_12421_SocketServer_A03(SocketChannel socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Add your code here to handle the client connection securely
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer().start();
    }
}