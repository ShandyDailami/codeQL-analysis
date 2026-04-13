import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_20053_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        // Create a socket server on port 8000
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(8000);
        System.out.println("Server started at port 8000");

        while (true) {
            // Accept a new client connection
            Socket clientSocket = serverSocket.accept();

            // Create input and output stream for client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read the client's message
            String message = in.readLine();

            // Check for specific security violation, e.g., "Broken Access Control"
            if (message.contains("BrokenAccessControl")) {
                System.out.println("Security violation detected: " + message);
                out.println("Access Denied");
            } else {
                System.out.println("Client says: " + message);
                out.println("Server says: " + message);
            }

            // Close the connection
            clientSocket.close();
        }
    }
}