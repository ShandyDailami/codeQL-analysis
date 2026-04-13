import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_24664_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 8080;
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            // Accept a client socket
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getRemoteSocketAddress());

            // Read data from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send a response to the client
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Hello, client!");

            // Close the connection
            client.close();

            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}