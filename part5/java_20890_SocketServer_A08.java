import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_20890_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        System.out.println("Server started on port " + PORT + "...");

        // Create a server socket
        var serverSocket = new ServerSocket(PORT);

        while (true) {
            // Accept a new client
            var clientSocket = serverSocket.accept();

            // Create new input and output streams
            var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            var out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Handle the client's request
            var request = in.readLine();
            System.out.println("Received: " + request);

            // Simulate a security-sensitive operation
            if (request.contains("sensitive")) {
                // Fail integrity check
                out.println("Failure");
                System.out.println("Client disconnected due to integrity failure");
            } else {
                // Continue the communication
                out.println("Success");
            }

            // Close the connection
            clientSocket.close();
        }
    }
}