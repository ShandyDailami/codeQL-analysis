import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_16175_SocketServer_A01 {

    private static final int PORT = 8080;
    private static final int CORE_POOL_SIZE = 10;
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(CORE_POOL_SIZE);

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected!");
                threadPool.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        } finally {
            threadPool.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_16175_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client request and response here
            // For the sake of simplicity, we'll just echo back the message
            try {
                while ((clientSocket.getInputStream().read()) != -1) {
                    clientSocket.getOutputStream().write("Message received".getBytes());
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            }
        }
    }
}