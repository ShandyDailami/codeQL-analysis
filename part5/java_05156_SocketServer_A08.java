import java.io.*;
import java.net.*;

public class java_05156_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket server = new ServerSocket(5000);

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Receive a message from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            out.println("Thank you for connecting to " + client.getRemoteSocketAddress() + "!");
       
            // Close the connection
            client.close();
        }
    }
}