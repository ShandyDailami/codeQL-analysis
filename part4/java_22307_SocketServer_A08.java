import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_22307_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080...");

        while (true) {
            // Accept a client connection
            Socket clientSocket = serverSocket.accept();

            System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Create a reader for the client socket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Create a writer for the client socket
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Receive a message from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            out.println("Hello, client!");

            // Close the connection
            clientSocket.close();
        }
    }
}