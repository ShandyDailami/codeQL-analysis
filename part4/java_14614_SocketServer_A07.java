import java.io.*;
import java.net.*;

public class java_14614_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Waiting for a client to connect...");

            Socket client = server.accept();
            System.out.println("Client connected!");

            // Read from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String message = reader.readLine();
            System.out.println("Received message: " + message);

            // Send a response
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("Hello client, you connected successfully!");

            // Close the connection
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}