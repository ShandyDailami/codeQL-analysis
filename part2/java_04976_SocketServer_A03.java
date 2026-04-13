import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_04976_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a new Socket instance for the server
            Socket server = new Socket("localhost", 1234);

            // Get the input and output streams from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);

            // Send a message to the server
            out.println("Hello from the server!");

            // Read the server's response
            String response = in.readLine();
            System.out.println("Server's response: " + response);

            // Close the connection
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}