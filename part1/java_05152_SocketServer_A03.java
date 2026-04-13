import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_05152_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create server socket
        Socket serverSocket = new Socket("localhost", 5000);

        // Get input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);

        // Start communication with client
        String input;
        while ((input = in.readLine()) != null) {
            System.out.println("Received: " + input);

            // Check if it's a command to quit
            if (input.equals("quit")) {
                break;
            }

            // Send a response back to the client
            out.println("Server says: Hello, client!");
        }

        // Close the connections
        in.close();
        out.close();
        serverSocket.close();
    }
}