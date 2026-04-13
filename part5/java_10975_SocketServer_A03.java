import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_10975_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        int port = 5000; // Change port number as required

        // Create a server socket
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);

        while (true) {
            // Accept a client connection
            Socket socket = serverSocket.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read a request from the client
            String request = in.readLine();

            // Process the request (e.g., check for SQL injection or other injection technique)
            if (request.contains("DROP TABLE")) {
                // Respond to the client
                out.println("Attempting to drop a table...");
            } else {
                // Respond to the client
                out.println("Received: " + request);
            }

            // Close the connection
            socket.close();
        }
    }
}