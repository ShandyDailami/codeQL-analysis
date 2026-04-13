import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_30193_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server...");

        // Create server socket
        var serverSocket = new ServerSocket(PORT);

        while (true) {
            // Wait for client to connect
            var clientSocket = serverSocket.accept();

            // Create input and output stream
            var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            var out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Receive request from client
            var request = in.readLine();
            System.out.println("Received request: " + request);

            // Check if it's a valid request, otherwise send error response
            if (request.equals("A01_BrokenAccessControl")) {
                out.println("Access granted");
            } else {
                out.println("Access denied");
            }

            // Close connection
            clientSocket.close();
        }
    }
}