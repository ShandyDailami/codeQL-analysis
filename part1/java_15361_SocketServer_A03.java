import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_15361_SocketServer_A03 {
    private static final int NUM_THREADS = 5;

    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_15361_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executor = Executors.newFixedThreadPool(NUM_THREADS);
    }

    public void start() {
        System.out.println("Server is starting...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted a new client connection: " + clientSocket.getRemoteSocketAddress());
                ClientHandler handler = new ClientHandler(clientSocket);
                executor.execute(handler);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        executor.shutdown();
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(8000);
        server.start();
    }
}