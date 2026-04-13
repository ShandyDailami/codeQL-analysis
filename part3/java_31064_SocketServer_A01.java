import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_31064_SocketServer_A01 {
    private static final int PORT = 4444;
    private static ExecutorService executor;

    public static void main(String[] args) {
        // Create a new executor with 4 threads
        executor = Executors.newFixedThreadPool(4);

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Pass the socket to the handler
                Handler handler = new Handler(socket);
                executor.execute(handler);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}