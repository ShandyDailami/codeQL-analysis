import java.io.*;
import java.net.*;

public class java_25054_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is listening on port " + PORT);

        while (true) {

            // Accept a new client
            Socket clientSocket = serverSocket.accept();

            // Create a new thread for the client
            Thread thread = new Thread(new ClientHandler(clientSocket));

            // Start the new thread
            thread.start();

            // Log that a new client has connected
            System.out.println("New client connected");
        }
    }

    // Handles incoming client connections
    private static class ClientHandler implements Runnable {

        private Socket clientSocket;

        public java_25054_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {

            try (InputStreamReader reader = new InputStreamReader(clientSocket.getInputStream());
                 BufferedReader in = new BufferedReader(reader)) {

                // Get the client's message
                String message = in.readLine();

                // Log the message
                System.out.println("Received: " + message);

                // Echo the message back to the client
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                writer.println("Echo: " + message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}