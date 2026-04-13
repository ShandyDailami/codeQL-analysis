import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_05792_SocketServer_A07 {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 5000;

    private static final int POOL_SIZE = 5;

    private final ExecutorService executorService;

    public java_05792_SocketServer_A07() {
        executorService = Executors.newFixedThreadPool(POOL_SIZE);
    }

    public void startServer() {
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                SocketChannel clientChannel = serverChannel.accept();
                System.out.println("Client connected: " + clientChannel.socket().getRemoteSocketAddress());

                ClientHandler handler = new ClientHandler(clientChannel);
                executorService.submit(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer().startServer();
    }
}