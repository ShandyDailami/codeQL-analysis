import java.io.*;
import java.net.*;

public class java_34661_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket on port 8080
        ServerSocket server = new ServerSocket(8080);

        // Accept incoming connections
        System.out.println("Server is listening on port 8080");
        Socket socket = server.accept();

        // Create input and output streams
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String inputLine;

        // Read incoming messages
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);

            // Respond to client
            out.println("Hello, you connected to port 8080!");
        }

        // Close the socket
        socket.close();
    }
}