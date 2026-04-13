import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_23049_SocketServer_A01 {
    private static final int PORT = 8189;
    private static final int NTHREADS = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
        try (ServerSocketChannel server = ServerSocketChannel.open()) {
            server.bind(new InetSocketAddress(PORT));
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                SocketChannel client = server.accept();
                System.out.println("Accepted connection from " + client.getRemoteAddress());
                executor.execute(new SocketHandler(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class SocketHandler implements Runnable {
        private SocketChannel client;

        SocketHandler(SocketChannel client) {
            this.client = client;
        }

        @Override
        public void run() {
            // handle client
        }
    }
}