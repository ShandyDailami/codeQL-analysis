import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_06002_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Create a new socket on port 12345
            Socket socket = new Socket("localhost", 12345);

            // Create a buffered reader to read the server's response
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Create a print writer to send data to the server
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Send a request to the server
            writer.println("A07_AuthFailure");

            // Read the server's response
            String response = reader.readLine();

            // Close the connection
            socket.close();

            // Print the response
            System.out.println("Server response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}