import java.io.*;
import java.net.*;

public class java_00369_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and listen for connections on port 12345
        ServerSocket server = new ServerSocket(12345);

        System.out.println("Server is listening on port 12345");

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();

            // Get an input stream from the client
            InputStream input = client.getInputStream();

            // Get an output stream to the client
            OutputStream output = client.getOutputStream();

            // Create a reader and writer for the client's input and output
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            DataOutputStream writer = new DataOutputStream(output);

            // Send a message to the client
            writer.writeUTF("Hello, Client!");

            // Close the connection
            writer.close();
            client.close();
        }
    }
}