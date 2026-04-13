import java.io.*;
import java.net.*;

public class java_40647_SocketServer_A07 {

    private static final int port = 8080;

    public static void main(String[] args) throws IOException {

        // Create a socket for the given port
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            System.out.println("Waiting for a client to connect...");

            // Accept a client socket
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected!");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_40647_SocketServer_A07(Socket socket) {
        this.socket = socket;

        try {
            // Initialize input and output streams
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            // Send a welcome message
            writer.println("Welcome to the server!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;

        try {
            // Receive a message from the client
            message = reader.readLine();

            // Check if the client disconnected
            if (message == null) {
                System.out.println("Client disconnected!");
                return;
            }

            // Process the message (e.g., check authentication)
            // For this example, we'll just print the received message
            System.out.println("Received message: " + message);

            // Send a response back to the client
            writer.println("Server received: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}