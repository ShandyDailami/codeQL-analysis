import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_22085_SocketServer_A07 {
    public static void main(String[] args) {
        // Create a new server socket on port 1234
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server started on port 1234");

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress());

            // Create input and output streams
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                // Get the client's message
                String message = in.readLine();
                System.out.println("Client says: " + message);

                // Check if the message is a specific command for authentication failure
                if (message.equals("/authfail")) {
                    // Generate a response
                    String response = "500 ERROR: Authentication failure";

                    // Send the response back to the client
                    out.println(response);
                } else {
                    // If not an authentication failure command, just reply with a generic response
                    String response = "200 OK: " + message;
                    out.println(response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}