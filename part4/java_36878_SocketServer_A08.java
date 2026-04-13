import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_36878_SocketServer_A08 {

    private static final int PORT = 8080;
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Accepted a connection from " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for each client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                executorService.submit(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_36878_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here we assume that the client wants to see a static HTML file
                String response = "HTTP/1.1 200 OK\n" +
                        "Content-Type: text/html\n\n" +
                        "<html><body><h1>Hello, World!</h1></body></html>";

                socket.getOutputStream().write(response.getBytes());

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}