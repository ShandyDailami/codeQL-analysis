import java.io.*;
import java.net.*;

public class java_27955_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(6000);

        // Accept incoming connections
        System.out.println("Waiting for client...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // Get input and output streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(clientSocket.getInputStream()));

        // Read from the client
        String input;
        while ((input = in.readLine()) != null) {
            System.out.println("Received: " + input);

            // Respond to the client
            out.println("Hello, Client");
        }

        // Close the connection
        clientSocket.close();
    }
}