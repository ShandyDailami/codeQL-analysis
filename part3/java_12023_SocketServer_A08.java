import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_12023_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        int port = 4444; // Choose a port
        ServerSocket serverSocket = new ServerSocket(port); // Create a server socket

        System.out.println("Waiting for client on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept(); // Accept a client connection

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read a line from the client
            String line = in.readLine();

            // Process the line (e.g., send a response)
            if ("exit".equals(line)) {
                break;
            }

            // Send a response
            out.println("Server received: " + line);

            // Close the connection
            clientSocket.close();
        }

        serverSocket.close();
    }
}