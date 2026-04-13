import java.io.*;
import java.net.*;

public class java_02105_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create a server socket and wait for a client to connect
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        // Accept a client connection
        Socket client = server.accept();
        System.out.println("Client connected...");

        // Create input and output streams
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        // Send a greeting message
        out.println("Hello Client, How are you?");

        // Read a greeting message from the client
        String greeting = in.readLine();
        System.out.println("Client: " + greeting);

        // Close the connection
        client.close();
        server.close();
    }
}