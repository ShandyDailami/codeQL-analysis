import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02090_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a server socket on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is running on port 12345...");

        while (true) {
            // Accept a client socket
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Create a reader for the input from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Create a writer for the output to the client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read a line of text from the client
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Respond to the client
            writer.println("Server received your message: " + message);

            // Close the connections
            clientSocket.close();
        }
    }
}