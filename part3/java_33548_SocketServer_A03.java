import java.io.*;
import java.net.*;

public class java_33548_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a socket and bind it to a port
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is running on port 8080");

            while (true) {
                // Wait for a connection
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new input stream and output stream for the socket
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Read the client message
                String message = in.readLine();
                System.out.println("Received: " + message);

                // Respond to the client
                out.println("Hello, Client!");
           
                // Close the socket
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}