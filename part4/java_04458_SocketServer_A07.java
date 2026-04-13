import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04458_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a ServerSocket
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            // Step 2: Wait for a client to connect
            Socket client = server.accept();
            System.out.println("Client connected from: " + client.getRemoteSocketAddress());

            // Step 3: Create input and output streams
            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            // Step 4: Authentication
            String username = input.readUTF();
            String password = input.readUTF();

            if (isValidUser(username, password)) {
                // Step 5: Send a success message to the client
                output.writeUTF("Authentication successful");
            } else {
                // Step 6: Send an error message to the client
                output.writeUTF("Authentication failed");
            }

            // Step 7: Close the connection
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method is a placeholder and should be replaced by your own method for checking user authentication
    private static boolean isValidUser(String username, String password) {
        // This is a simple check for username and password. Real world applications should use a secure method for authentication.
        return username.equals("admin") && password.equals("password");
    }
}