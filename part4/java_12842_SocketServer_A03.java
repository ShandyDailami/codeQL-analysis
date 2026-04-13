import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_12842_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        Socket serverSocket = new Socket("localhost", 1234);

        // Create a reader to receive client messages
        BufferedReader reader = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

        // Create a writer to send back server responses
        PrintWriter writer = new PrintWriter(serverSocket.getOutputStream(), true);

        // Read the client message
        String clientMessage = reader.readLine();

        // Process the client message (for example, log it)
        System.out.println("Received message: " + clientMessage);

        // Send back a response
        writer.println("Server response: " + clientMessage);

        // Close the resources
        reader.close();
        writer.close();
        serverSocket.close();
    }
}