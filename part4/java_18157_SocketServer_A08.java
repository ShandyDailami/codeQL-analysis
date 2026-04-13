import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_18157_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(8080);

            // Wait for a client to connect
            Socket client = server.accept();

            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Receive a message from the client
            String message = in.readLine();

            // Process the message (for example, echo it back)
            out.println("Server received: " + message);

            // Close the connection
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}