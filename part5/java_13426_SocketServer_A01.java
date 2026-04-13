import java.io.*;
import java.net.*;

public class java_13426_SocketServer_A01 {

    // The port on which the server should listen for connections
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started, waiting for connections...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new thread for handling each client
            Thread clientHandler = new Thread(new ClientHandler(clientSocket));
            clientHandler.start();
        }
    }

    // Represents a single client connection
    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_13426_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (InputStream input = clientSocket.getInputStream();
                 OutputStream output = clientSocket.getOutputStream()) {

                // Read the client's message
                DataInputStream in = new DataInputStream(input);
                DataOutputStream out = new DataOutputStream(output);

                String message = in.readUTF();
                System.out.println("Received message: " + message);

                // Send a response back to the client
                String response = "Hello, client!";
                out.writeUTF(response);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}