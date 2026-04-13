import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_18439_SocketServer_A07 {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            // Create a new socket
            socket = new Socket("localhost", 1234);

            // Get the reader and writer from the socket
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server
            writer.println("Hello, Server!");

            // Read the response from the server
            String response = reader.readLine();
            System.out.println("Server says: " + response);

            // Close the resources
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}