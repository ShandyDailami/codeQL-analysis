import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_14869_SocketServer_A07 {
    private static final String SERVER_NAME = "Secure Socket Server";
    private static final int PORT = 9999;

    public static void main(String[] args) {
        System.out.println("Starting " + SERVER_NAME + "...");

        // Create a new thread for each client connection
        while (true) {
            try (Socket clientSocket = new Socket("localhost", PORT);
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("Connected to client");

                // Send a welcome message
                out.println("Welcome to " + SERVER_NAME);

                // Receive the request from the client
                String request = in.readLine();
                System.out.println("Received: " + request);

                // Echo the request back to the client
                out.println(request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}