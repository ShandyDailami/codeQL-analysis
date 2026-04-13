import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_19501_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);

        System.out.println("Server is listening on port 12345");

        // Accept a client connection
        Socket clientSocket = serverSocket.accept();

        // Create a reader for the input stream from the client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Create a writer for the output stream to the client
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String inputLine;

        // Read from the client
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);

            // Process the received message
            String response = processMessage(inputLine);

            // Send the response to the client
            out.println(response);
        }

        // Close the connections
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    private static String processMessage(String message) {
        // Simulate a security breach by processing the message
        if (message.contains("admin")) {
            return "Access denied for admin access!";
        }

        return "Access granted!";
    }
}