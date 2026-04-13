import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_23453_SocketServer_A01 {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final int CORE_POOL_SIZE = 2;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
            serverSocketChannel.configureBlocking(false);
            System.out.println("Server is listening on port " + SERVER_PORT);
            while (true) {
                SocketChannel clientChannel = serverSocketChannel.accept();
                if (clientChannel != null) {
                    System.out.println("New client connected");
                    executorService.execute(new ClientHandler(clientChannel));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final SocketChannel clientChannel;

        public java_23453_SocketServer_A01(SocketChannel clientChannel) {
            this.clientChannel = clientChannel;
        }

        @Override
        public void run() {
            // TODO: handle client communication
        }
    }
}