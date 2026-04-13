import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_26846_SocketServer_A03 {
    private static final int PORT = 12345;
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private final BufferedReader in;
        private final PrintWriter out;

        public java_26846_SocketServer_A03(Socket socket) {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = in.readLine()) != null) {
                    processRequest(request);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void processRequest(String request) {
            // You can implement your security-sensitive operations here
            // For example, check if the request contains a SQL injection or command injection
            // If so, prevent the request from being processed

            // Implement your response here
            out.println("Your response here");
            out.flush();
        }
    }
}