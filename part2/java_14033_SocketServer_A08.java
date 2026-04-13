import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_14033_SocketServer_A08 {
    private final ExecutorService executor;
    private final ServerSocket server;

    public java_14033_SocketServer_A08(int port) throws IOException {
        server = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() {
        System.out.println("Server started!");
        while (true) {
            try {
                handleRequest(server.accept());
            } catch (IOException e) {
                System.out.println("Failed to accept connection: " + e.getMessage());
            }
        }
    }

    private void handleRequest(Socket clientSocket) throws IOException {
        // Create a new thread for each client connection
        executor.execute(new ClientHandler(clientSocket));
    }

    private class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_14033_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = clientSocket.getInputStream();
                 OutputStream out = clientSocket.getOutputStream()) {

                // Read the client's request
                int request;
                while ((request = in.read()) != -1) {
                    // Send a response back to the client
                    out.write(request);
                    out.flush();
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            } finally {
                // Close the client connection
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(8080);
        server.startServer();
    }
}