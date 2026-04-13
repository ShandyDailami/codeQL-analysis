import java.net.*;
import java.io.*;

public class java_39438_SocketServer_A01 {
    public static void main(String[] args) {
        // Define the port number
        int port = 12345;

        try {
            // Start a server socket
            ServerSocket serverSocket = new ServerSocket(port);

            while(true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();

                // Get the input and output streams
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Request from the client
                String input = in.readLine();

                // Handle the request
                String response = handleRequest(input);

                // Send the response to the client
                out.println(response);

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String handleRequest(String request) {
        // Simulate security-sensitive operations
        if (request.equals("password")) {
            return "Access denied!";
        }

        return "Access granted!";
    }
}