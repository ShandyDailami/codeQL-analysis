import java.io.*;
import java.net.*;

public class java_29834_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a socket and bind it to port 4444
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server listening on port 4444");

            while (true) {
                // Wait for a client to connect
                Socket client = server.accept();

                // Create input and output streams
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                // Send a message to the client
                out.println("Hello from server!");

                // Read a line from the client
                String message = in.readLine();
                System.out.println("Client says: " + message);

                // Close the streams
                in.close();
                out.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}