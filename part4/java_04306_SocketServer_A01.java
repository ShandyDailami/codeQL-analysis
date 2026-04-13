import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04306_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a new ServerSocket and wait for client connections
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Waiting for a client to connect...");

            // Accept a new client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to the client");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read from the client
            String message = in.readLine();
            System.out.println("Client says: " + message);

            // Reply to the client
            out.println("Hello, client!");

            // Close the connection
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}