import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17941_SocketServer_A07 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server is listening on port " + SERVER_PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Receive username and password from the client
            String username = reader.readLine();
            String password = reader.readLine();

            // Check if the received username and password match the predefined ones
            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                System.out.println("Client authenticated");
                // Send success message to the client
                writer.println("Authentication successful");
            } else {
                System.out.println("Authentication failed");
                // Send failure message to the client
                writer.println("Authentication failed");
            }

            socket.close();
        }
    }
}