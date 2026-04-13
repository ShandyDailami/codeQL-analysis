import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10913_SocketServer_A07 {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(SERVER_PORT);
        System.out.println("Server started on port: " + SERVER_PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected: " + client.getRemoteSocketAddress());

            // Authentication
            String username = client.getRemoteSocketAddress().toString();
            String password = "password"; // Hardcoded password for simplicity

            if (isValidUser(username, password)) {
                handleClient(client);
            } else {
                System.out.println("Invalid username or password");
                client.close();
            }
        }
    }

    private static boolean isValidUser(String username, String password) {
        // Implementation of authentication mechanism goes here.
        // For simplicity, this method returns true if the username and password match,
        // in a real application you would probably want to hash the password and compare the hash
        return username.equals("username") && password.equals("password");
    }

    private static void handleClient(Socket client) throws IOException {
        // Implementation of client communication goes here.
        // For simplicity, this method reads a line from the client and sends it back
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String message = reader.readLine();

        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
        writer.println("Message received: " + message);
    }
}