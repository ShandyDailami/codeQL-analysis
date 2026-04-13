import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_09115_SocketServer_A07 {

    public static void main(String[] args) {
        // Create a new server socket
        try (Socket socket = new Socket("localhost", 12345)) {

            // Create input and output streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Send a greeting message
            writer.println("Hello, client!");

            // Read a response
            String response = reader.readLine();
            System.out.println("Server response: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}