import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_09861_SocketServer_A01 {

    public static void main(String[] args) throws Exception {

        int port = 4444;

        System.out.println("Starting server on port " + port);

        // Create a server socket
        var server = new ServerSocket(port);

        // Keep listening until an exception is caught and the server is closed
        while (true) {
            try {
                // When a client connects, accept the connection
                var client = server.accept();

                // Create a writer for the client
                var out = new PrintWriter(client.getOutputStream(), true);

                // Create a reader for the client
                var in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                // Send a message to the client
                out.println("Welcome to the server!");

                // Wait for a command from the client
                String command = in.readLine();

                // Close the connection
                client.close();

                // Print out the command received
                System.out.println("Received command: " + command);

            } catch (Exception e) {
                e.printStackTrace();
                server.close();
            }
        }
    }
}