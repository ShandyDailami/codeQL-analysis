import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_01543_SocketServer_A07 {

    private static final int PORT = 9876;
    private static final int CORE_POOL_SIZE = 10;

    private final ExecutorService executorService;

    public java_01543_SocketServer_A07() {
        executorService = Executors.newFixedThreadPool(CORE_POOL_SIZE);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                executorService.execute(new ClientHandler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocketServer().start();
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_01543_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: handle client communication, add authentication and authorization checks
        }
    }
}