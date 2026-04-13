import java.io.*;
import java.net.*;

public class java_39843_SocketServer_A01 {

    // Main method
    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(1234);

        // Wait for a client to connect
        System.out.println("Waiting for client...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // Get input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Handle client communication
        String clientMessage;
        while ((clientMessage = in.readLine()) != null) {
            System.out.println("Received: " + clientMessage);

            // Here we're using a simple security-sensitive operation related to A01_BrokenAccessControl
            // This operation is simple and not recommended for production use.
            if (clientMessage.equals("secret")) {
                out.println("Access denied");
            } else {
                out.println("Access granted");
            }

            // Flush the output stream
            out.flush();
        }

        // Close the connection
        clientSocket.close();
        serverSocket.close();
    }
}