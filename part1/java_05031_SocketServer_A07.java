import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05031_SocketServer_A07 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                try (Socket client = server.accept()) {
                    System.out.println("Client connected: " + client.getRemoteSocketAddress());

                    // Read the username from the client
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(client.getInputStream()));
                    String username = in.readLine();

                    // Check if the username is valid (this is a placeholder and is not secure)
                    if ("validUser".equals(username)) {
                        // Send a welcome message to the client
                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                        out.println("Welcome, " + username + "!");
                    } else {
                        // Send an authentication failure message to the client
                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                        out.println("Authentication failure!");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}