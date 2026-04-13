import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_09830_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create server socket
        Socket socket = new Socket("localhost", 12345);

        // Create input stream from socket
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Create output stream to socket
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        // Send a request to the server
        writer.println("Hello, client!");

        // Read the response from the server
        String response = reader.readLine();
        System.out.println("Server response: " + response);

        // Close the resources
        reader.close();
        writer.close();
        socket.close();
    }
}