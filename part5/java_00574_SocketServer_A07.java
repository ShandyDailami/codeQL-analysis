import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_00574_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        // Set up the server socket
        int port = 8080;
        System.out.println("Starting server on port " + port);
        ServerSocket serverSocket = new ServerSocket(port);

        // Wait for a client to connect
        Socket clientSocket = serverSocket.accept();
        System.out.println("Connected to client");

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Handle the client's requests
        String request;
        while ((request = in.readLine()) != null) {
            if (request.equals("auth fail")) {
                // In a real-world application, you would also want to handle this case in a secure way
                // For simplicity, we'll just send an error message back to the client
                out.println("Authentication failed");
            } else {
                out.println("Received: " + request);
            }
        }

        // Close the connection
        clientSocket.close();
        serverSocket.close();
    }
}