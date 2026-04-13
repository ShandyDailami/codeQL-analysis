import java.io.*;
import java.net.*;

public class java_15328_SocketServer_A08 {
    public static void main(String[] args) {
        // Create a socket for a specific port
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            // Accept a client
            Socket client = server.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read a message from the client
            String message = in.readLine();
            System.out.println("Received message: " + message);

            // Send a response
            out.writeUTF("Hello, client!");
            out.flush();

            // Close the streams
            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}