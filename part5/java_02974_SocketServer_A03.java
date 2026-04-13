import java.io.*;
import java.net.*;

public class java_02974_SocketServer_A03 {
    private static final int PORT = 6000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public java_02974_SocketServer_A03(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
             BufferedReader reader = new BufferedReader(in)) {

            // Read message from the client
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Simulate a security-sensitive operation
            String response = processMessage(message);

            // Send the response back to the client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println(response);
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }

    private String processMessage(String message) {
        // Inject code here

        // For example, replace all occurrences of 'bad' with 'good'
        message = message.replace("bad", "good");
        return message;
    }
}