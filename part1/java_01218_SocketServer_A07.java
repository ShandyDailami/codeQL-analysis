import java.io.*;
import java.net.*;

public class java_01218_SocketServer_A07 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(4444);
            System.out.println("Waiting for a client...");

            socket = server.accept();
            System.out.println("Client connected!");

            // Create a new InputStreamReader and BufferedReader for the socket
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Read the message from the client
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Check if the message is "auth"
            if (message.equals("auth")) {
                // If it is, write a response
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("auth successful");
            } else {
                // If it's not, write an error message
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("auth failed");
            }

            // Close the connection
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Ensure the server socket is closed
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}