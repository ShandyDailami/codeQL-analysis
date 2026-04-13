import java.net.*;
import java.io.*;

public class java_35931_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        // Set up a server socket
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();
            System.out.println("Client connected");

            // Set up input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Authenticate the client
            String username = in.readLine();
            if (!authenticate(username)) {
                out.println("Authentication failed");
                out.close();
                client.close();
                continue;
            }

            // Handle incoming messages from the client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Hello, " + message);
            }

            // Close the connection
            out.close();
            client.close();
        }
    }

    // Simulate authentication
    private static boolean authenticate(String username) {
        // This is a simplified authentication mechanism. In a real-world scenario,
        // you would need to implement more complex logic for security purposes.
        return username.equals("admin");
    }
}