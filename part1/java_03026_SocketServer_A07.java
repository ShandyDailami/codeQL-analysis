import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03026_SocketServer_A07 {

    // Define the username and password
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Authenticate the client
                authenticateClient(socket);
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port 8080. Exiting...");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void authenticateClient(Socket socket) {
        try {
            // Read the username and password from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String username = reader.readLine();
            String password = reader.readLine();

            // Check if the credentials are correct
            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
                System.out.println("Authentication successful.");
            } else {
                System.out.println("Authentication failed.");
                // If the credentials are incorrect, close the connection
                socket.close();
            }
        } catch (IOException e) {
            System.err.println("Failed to authenticate client. Closing connection...");
            e.printStackTrace();
        }
    }
}