import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class java_02450_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            // Create a new Socket server on port 12345
            // This port should not be exposed to the public internet
            Socket socket = new Socket("localhost", 12345);

            // Get the output stream from the socket
            OutputStream outputStream = socket.getOutputStream();

            // Create a reader to read from the socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send a welcome message to the client
            outputStream.write("Welcome to the server!\n".getBytes());

            // Read the response from the client
            String response = reader.readLine();
            System.out.println("Received: " + response);

            // Close the socket and the reader
            socket.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}