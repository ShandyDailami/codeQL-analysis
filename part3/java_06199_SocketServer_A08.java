import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_06199_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a socket
            Socket socket = new Socket("localhost", 12345);

            // Create input and output streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the client
            writer.println("Hello, Client!");

            // Read the response from the client
            String response = reader.readLine();
            System.out.println("Server Response: " + response);

            // Close the connection
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}