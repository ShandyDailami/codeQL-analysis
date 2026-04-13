import java.io.*;
import java.net.*;

public class java_00806_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a socket for the server
        ServerSocket server = new ServerSocket(5555);
        System.out.println("Server is running on port 5555...");

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();
            System.out.println("Client connected");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Read a line of input from the client
            String request = in.readLine();
            System.out.println("Received request: " + request);

            // Check for known attack patterns
            if (request.contains("password=")) {
                // If found, send a response
                out.println("Access denied");
            } else {
                // Otherwise, continue
                out.println("Access granted");
            }

            // Close the connection
            client.close();
        }
    }
}