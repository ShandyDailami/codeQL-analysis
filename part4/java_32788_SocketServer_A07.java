import java.net.SocketException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;

public class java_32788_SocketServer_A07 {

    // Hard-coded list of known users
    private static final String[] KNOWN_USERS = {"user1", "user2", "user3"};

    // Main method
    public static void main(String[] args) {
        try {
            // Create a ServerSocket with a specific port
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                // Accept a client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Get input and output streams
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();

                // Read the client's username
                byte[] usernameBytes = new byte[1024];
                input.read(usernameBytes);
                String username = new String(usernameBytes);

                // Check if the client's username is known
                if (Arrays.asList(KNOWN_USERS).contains(username)) {
                    // If the username is known, send a response
                    output.write("Success\n".getBytes());
                } else {
                    // If the username is not known, send an authentication failure response
                    output.write("Authentication failure\n".getBytes());
                }

                // Close the connection
                clientSocket.close();
            }
        } catch (SocketException e) {
            System.out.println("Socket exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O exception: " + e.getMessage());
        }
    }
}