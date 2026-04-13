import java.io.*;
import java.net.*;

public class java_00938_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");

        while (true) {
            // Accept a new client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            // Handle client communication
            String clientMessage = in.readLine();
            System.out.println("Received message: " + clientMessage);

            // Send response to client
            String serverMessage = "Hello, client!";
            out.write("Server says: " + serverMessage);
            out.newLine();
            out.flush();

            // Close the connection
            clientSocket.close();
        }
    }
}