import java.io.*;
import java.net.*;

public class java_15546_SocketServer_A07 {

    private static final String SERVER_SOFTWARE = "My Server";
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        // Create a socket and bind it to a port
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running...");

        // Accept a client
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // Create a input and output stream
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Handle client messages
        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);

            // Assume the client is authenticated. If not, close the connection.
            if ("auth".equals(message)) {
                out.println("Auth successful");
            } else {
                out.println("Auth failed");
                clientSocket.close();
            }
        }

        // Close the client socket and server socket
        clientSocket.close();
        serverSocket.close();
    }
}