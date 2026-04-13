import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_23290_SocketServer_A08 {

    private static final int PORT = 8080;
    private static final String AUTHENTICATION_REQUIRED = "Authentication Required.";

    private final ExecutorService executorService;

    public java_23290_SocketServer_A08(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for client connections...");

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                Handler handler = new Handler(clientSocket, this);
                executorService.execute(handler);
            } catch (IOException e) {
                System.out.println("Error handling client connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(10, 50, 120, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        SecureSocketServer server = new SecureSocketServer(executorService);
        server.start();
    }

    private class Handler implements Runnable {

        private final Socket socket;
        private final SecureSocketServer server;

        public java_23290_SocketServer_A08(Socket socket, SecureSocketServer server) {
            this.socket = socket;
            this.server = server;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Here you can add code for authentication.
                    // If the client is not authenticated, send an error message.
                    if (message.equals(AUTHENTICATION_REQUIRED)) {
                        out.println("Authentication failed.");
                        out.flush();
                    } else {
                        out.println("Message received.");
                        out.flush();
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client connection: " + e.getMessage());
            }
        }
    }
}