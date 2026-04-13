import java.io.*;
import java.net.*;

public class java_15848_SocketServer_A07 {

    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocket server = new ServerSocket(1234);

        // Accept a client socket
        Socket client = server.accept();

        // Create input and output streams
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(client.getInputStream()));

        // Read the client's message
        String message = in.readLine();
        System.out.println("Client says: " + message);

        // Send a response back to the client
        out.println("Hello, client!");

        // Close the connection
        client.close();
        server.close();
    }
}