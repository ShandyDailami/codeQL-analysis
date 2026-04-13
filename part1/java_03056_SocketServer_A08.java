import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_03056_SocketServer_A08 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {

        // Initialize the executor service with 10 threads
        executor = Executors.newFixedThreadPool(10);

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        // Keep the server running until it is closed
        while (true) {
            System.out.println("Waiting for client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Handle the client connection in a new thread
            executor.execute(new ClientHandler(clientSocket));
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket clientSocket;

        public java_03056_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Handle the client's request
                String request = in.readLine();
                System.out.println("Received: " + request);

                // Send a response
                out.println("Hello, client!");
            } catch (IOException e) {
                System.out.println("Failed to handle client connection.");
            }
        }
    }
}