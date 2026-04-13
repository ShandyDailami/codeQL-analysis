import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41113_SocketServer_A07 {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String AUTH_FAILURE_MESSAGE = "Authentication failed. Please try again.";

    public static void main(String[] args) {
        runServer();
    }

    private static void runServer() {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is running on " + SERVER_ADDRESS + ":" + SERVER_PORT);
            authenticate(server.accept());
        } catch (IOException e) {
            System.err.println("Server failed to start");
            e.printStackTrace();
        }
    }

    private static void authenticate(Socket socket) {
        try (Socket clientSocket = socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            System.out.println("Connected to client");
            out.println("Enter your password:");

            String password = in.readLine();

            if (password.equals("secret")) {
                out.println("Authentication successful!");
            } else {
                out.println(AUTH_FAILURE_MESSAGE);
            }
        } catch (IOException e) {
            System.err.println("Error processing client: " + e.getMessage());
        }
    }
}