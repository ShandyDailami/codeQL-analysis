import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28424_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and bind it to a port
        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080...");

        while (true) {
            // Accept a client connection
            Socket client = server.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Read a message from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            out.println("Hello, client!");
        }
    }
}