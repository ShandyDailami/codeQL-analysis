import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class java_37003_SocketServer_A07 {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String PASSWORD = "secure_password";

    public static void main(String[] args) throws IOException {
        // Create a server socket
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(SERVER_PORT);

        while (true) {
            // Accept a new client connection
            Socket clientSocket = serverSocket.accept();

            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStream out = clientSocket.getOutputStream();

            // Read the password from the client
            String clientPassword = in.readLine();

            // Check if the password matches
            if (clientPassword.equals(PASSWORD)) {
                // Authentication successful, send a success message
                out.write("Authentication successful!\n".getBytes());
            } else {
                // Authentication failed, send an error message
                out.write("Authentication failed!\n".getBytes());
            }

            // Close the connection
            clientSocket.close();
        }
    }
}