import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_38451_SocketServer_A03 {
    private static final String SERVER_MESSAGE = "Server is running...";
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);
        startServer();
    }

    private static void startServer() {
        System.out.println("Starting server at port " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_38451_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    String response = processRequest(message);
                    writer.println(response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private String processRequest(String request) {
            // TODO: Add security-sensitive operations here.
            // For instance, check for injection attacks.
            return SERVER_MESSAGE;
        }
    }
}