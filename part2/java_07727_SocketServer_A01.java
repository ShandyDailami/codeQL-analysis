import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_07727_SocketServer_A01 {
    private final int port;
    private final ExecutorService executorService;

    public java_07727_SocketServer_A01(int port) {
        this.port = port;
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Pass the socket to the thread pool for processing
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + port + ": " + e.getMessage());
        } finally {
            // Shutdown the executor service
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_07727_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // Handle the client connection and communication in here
            // This is a very basic example and should be expanded upon
            try (Socket connection = clientSocket) {
                // Read from the client
                // Write to the client
            } catch (IOException e) {
                System.err.println("Failed to handle client connection: " + e.getMessage());
            }
        }
    }
}