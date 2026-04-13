import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_06069_SocketServer_A08 {
    public static void main(String[] args) {
        // Create a server socket
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is running on port 8080");

            // Accept a new client
            try (Socket client = server.accept()) {
                System.out.println("Client connected");

                // Create input and output streams
                try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                    // Read from client
                    String request = in.readLine();
                    System.out.println("Received: " + request);

                    // Process request (example: integrity check)
                    if (request.equals("A08_IntegrityFailure")) {
                        // If request is 'A08_IntegrityFailure', send error response back to client
                        out.println("Error: A08_IntegrityFailure");
                    } else {
                        // Else, send success response back to client
                        out.println("Success");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}