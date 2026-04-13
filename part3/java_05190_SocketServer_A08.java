import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_05190_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            // Create a server socket and wait for a client connection
            ServerSocket server = new ServerSocket(8080);
            Socket socket = server.accept();

            // Create input and output stream
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read the client message
            String clientMessage = in.readLine();

            // Send a response back to the client
            out.println("Hello, client, your message was: " + clientMessage);

            // Close the resources
            in.close();
            out.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}