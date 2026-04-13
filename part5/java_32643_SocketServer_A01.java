import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32643_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(4242);

        System.out.println("Server is listening on port 4242");

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected");

            // Create a reader and writer for this client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send a welcome message back to the client
            out.println("Welcome to the server!");
        }
    }
}