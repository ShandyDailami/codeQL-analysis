import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_17564_SocketServer_A01 {

    private static final int PORT = 8080;
    private static final int CORE_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 100;
    private static final int KEEP_ALIVE_TIME = 5000;

    private final ExecutorService executorService;

    public java_17564_SocketServer_A01() {
        executorService = Executors.newFixedThreadPool(CORE_POOL_SIZE);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT, KEEP_ALIVE_TIME, InetAddress.getByName("127.0.0.1"))) {
            System.out.println("Server is listening on port: " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection accepted from: " + clientSocket.getRemoteSocketAddress());
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (Exception e) {
            System.out.println("Server Exception: " + e.getMessage());
            executorService.shutdown();
        }
    }

    private class ClientHandler implements Runnable {

        private final Socket clientSocket;

        public java_17564_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Perform security-sensitive operations related to A01_BrokenAccessControl
                // ...

                // Send response to client
                String response = "Server received your message successfully.";
                clientSocket.getOutputStream().write(response.getBytes());
            } catch (Exception e) {
                System.out.println("ClientHandler Exception: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer().start();
    }
}