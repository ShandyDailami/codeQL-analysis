import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23008_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and listen for incoming connections
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client connections...");

        while (true) {
            // Accept a new client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

            // Create a reader for the input stream of the client socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Create a writer for the output stream of the client socket
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read a message from the client
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            writer.println("Hello, client!");

            // Close the readers and writers
            reader.close();
            writer.close();
            clientSocket.close();
        }
    }
}