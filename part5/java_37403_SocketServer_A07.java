import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_37403_SocketServer_A07 {
    // Create a server socket
    private Socket socket;

    // Create a buffered reader and writer
    private BufferedReader in;
    private PrintWriter out;

    // Construct the server socket
    public java_37403_SocketServer_A07(Socket socket) {
        this.socket = socket;

        try {
            // Initialize the buffered reader and writer
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handle client input
    public void handleInput() {
        try {
            // Read a line of input from the client
            String input = in.readLine();

            // Handle the input
            if (input.equals("A07_AuthFailure")) {
                // If the input is "A07_AuthFailure", send a response
                out.println("Successfully authenticated");
            } else {
                out.println("Invalid input");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Main method for the server
    public static void main(String[] args) {
        // Start the server
        try {
            // Create a server socket
            Socket server = new Socket("localhost", 1234);

            // Create a new server thread
            SecureSocketServer serverThread = new SecureSocketServer(server);

            // Handle client input
            serverThread.handleInput();

            // Close the server socket
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}