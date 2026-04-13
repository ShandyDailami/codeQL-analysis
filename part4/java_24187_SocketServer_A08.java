import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_24187_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        // Create a server socket and listen on the specified port
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);
        System.out.println("Server is running on port: " + port);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            // Create a reader to read the client message
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Create a writer to send a response back to the client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read the client message
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            String response = "Hello, client, your message was: " + message;
            writer.println(response);

            // Close the connection
            clientSocket.close();
        }
    }
}