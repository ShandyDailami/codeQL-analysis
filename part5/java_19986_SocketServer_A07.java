import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_19986_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Create a new socket on port 12345 (any available port)
            Socket socket = new Socket("localhost", 12345);

            // Create a BufferedReader to read server's response
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create a PrintWriter to send messages to server
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Ask server for a greeting
            writer.println("A07_AuthFailure");

            // Wait for server's response
            String serverResponse = reader.readLine();
            System.out.println("Server said: " + serverResponse);

            // Close the socket
            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}