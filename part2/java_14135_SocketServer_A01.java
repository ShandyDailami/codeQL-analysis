import java.io.*;
import java.net.*;

public class java_14135_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and a client socket.
        ServerSocket server = new ServerSocket(12345);
        Socket client = server.accept();

        // Get input and output streams from the client socket.
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));

        // Read a message from the client.
        String message = in.readLine();
        System.out.println("Received: " + message);

        // Send back a message to the client.
        out.println("Hello, client!");

        // Close the connections.
        client.close();
        server.close();
    }
}