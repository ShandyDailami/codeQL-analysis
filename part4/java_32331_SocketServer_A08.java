import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32331_SocketServer_A08 {

    public static void main(String[] args) {
        // Step 1: Create a server socket
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");

            // Step 2: Wait for a client to connect
            Socket client = server.accept();
            System.out.println("Client connected");

            // Step 3: Communicate with the client
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                // Receive message from the client
                String message = in.readLine();
                System.out.println("Received: " + message);

                // Reply to the client
                if (message.equals("exit")) {
                    out.println("Server shutting down");
                } else {
                    out.println("Hello, client");
                }
            }

            // Step 4: Close the connection
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}