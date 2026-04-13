import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_39004_SocketServer_A03 {
    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_39004_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() throws IOException {
        System.out.println("Server started on port " + serverSocket.getLocalPort());

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                // Perform authentication
                authenticateClient(clientSocket);

                // Start a new thread for handling the client
                executor.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void authenticateClient(Socket clientSocket) throws IOException {
        // Here, you could use a more secure method for client authentication
        // For now, let's just check if the client is connected and authenticated
        if (clientSocket.isConnected()) {
            System.out.println("Client is authenticated");
        } else {
            System.out.println("Client is not connected");
            clientSocket.close();
            return;
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_39004_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // Handle client communication here
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(8080).startServer();
    }
}