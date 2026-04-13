import java.io.*;
import java.net.*;

public class java_28361_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a new socket server at port 8888
        ServerSocket server = new ServerSocket(8888);

        // Accept a new client connection
        Socket client = server.accept();

        // Create an input stream from the client
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        // Read a line from the client
        String message = in.readLine();

        // Print out the message from the client
        System.out.println("Client says: " + message);

        // Close the input and output streams
        in.close();
        client.close();
        server.close();
    }
}