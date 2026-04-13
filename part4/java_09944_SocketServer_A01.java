import java.io.*;
import java.net.*;

public class java_09944_SocketServer_A01 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and bind it to a port
            serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            // Accept a connection
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a buffered reader and writer
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the client
            writer.println("Hello client, you connected successfully!");

            // Read a line from the client
            String message = reader.readLine();
            System.out.println("Server received: " + message);

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}