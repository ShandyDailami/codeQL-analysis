import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20968_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Step 1: Create a ServerSocket
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            // Step 2: Accept a new connection
            Socket client = server.accept();
            System.out.println("Client connected");

            // Step 3: Create Input and Output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Step 4: Read a line from the client
            String line = in.readLine();
            System.out.println("Received: " + line);

            // Step 5: Send a line back to the client
            out.println("Hello, client!");
        }
    }
}