import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28398_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                Socket socket = server.accept();
                handleRequest(socket);
            }
        } catch (IOException e) {
            System.err.println("Server failed with exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        try {
            socket.getInputStream();
            socket.getOutputStream();

            // Read username and password from client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String username = reader.readLine();
            String password = reader.readLine();

            // Check if username and password match
            if (!username.equals(USERNAME) || !password.equals(PASSWORD)) {
                // If not, send error response to client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Error: Invalid username or password");
                return;
            }

            // If everything is correct, send success response to client
            writer.println("Success: Authentication successful");

        } catch (IOException e) {
            System.err.println("Error handling client with exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}