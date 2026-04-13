import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_10942_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 1234; // specify your port

        System.out.println("Server is listening on port " + port);

        // Start server
        while (true) {
            try (Socket socket = new Socket("localhost", port)) {
                System.out.println("Connected to client");

                // Create input and output stream
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Read the client's message
                String message = in.readLine();
                System.out.println("Received: " + message);

                // Send back a welcome message
                out.println("Welcome to the server!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}