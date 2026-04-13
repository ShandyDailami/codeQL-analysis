import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_30241_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        int port = 8080;

        // Create a server socket
        System.out.println("Starting server on port " + port);
        ServerSocket server = new ServerSocket(port);

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Receive a message from the client
            String message = in.readLine();
            System.out.println("Received message: " + message);

            // Send a response back to the client
            out.println("Hello, client!");
        }
    }
}