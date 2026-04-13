import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_26865_SocketServer_A03 {
    public static void main(String[] args) {
        // Start the server
        startServer();
    }

    private static void startServer() {
        Socket socket = null;
        try {
            // Create a new server socket at port 5000
            socket = new Socket("localhost", 5000);
            // Get the input stream from the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Get the output stream to the socket
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the client
            out.println("Hello, client!");

            // Read the server's response
            String response = in.readLine();
            System.out.println("Server response: " + response);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}