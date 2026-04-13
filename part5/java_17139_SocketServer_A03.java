import java.io.*;
import java.net.*;

public class java_17139_SocketServer_A03 {
    public static void main(String[] args) {
        // Create a socket for the server
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345...");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create streams for reading and writing
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                // Read a message from the client
                String message = in.readLine();
                System.out.println("Received: " + message);

                // Echo the message back to the client
                out.println(message);

                // Close the connection
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}