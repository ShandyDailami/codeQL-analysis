import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_01664_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a server socket
            Socket serverSocket = new Socket("localhost", 8080);

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);

            // Create a thread for the server
            Thread serverThread = new Thread(() -> {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Server received: " + message);
                    // Perform security-sensitive operations related to injection
                    // For example, remove all special characters and uppercase all letters
                    String sanitizedMessage = message.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
                    out.println("Server sanitized message: " + sanitizedMessage);
                }
            });

            // Start the server thread
            serverThread.start();

            // Generate a client socket
            Socket clientSocket = new Socket("localhost", 9090);

            // Create input and output streams
            BufferedReader clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream(), true);

            // Send a message from the client
            clientOut.println("Client message");

            // Get the server's response
            String response = clientIn.readLine();
            System.out.println("Server response: " + response);

            // Close the sockets
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}