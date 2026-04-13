import java.net.*;
import java.io.*;

public class java_13179_SocketServer_A08 {

    public static void main(String[] args) {

        // Establish the server socket
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080...");

            while (true) {
                // Accept a client connection
                Socket clientSocket = serverSocket.accept();

                // Create new input and output streams
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Receive message from client
                String message = in.readLine();
                System.out.println("Received message: " + message);

                // Send back message to client
                out.println("Hello, client, you sent this message: " + message);

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Error occurred in the server.");
            e.printStackTrace();
        }
    }
}