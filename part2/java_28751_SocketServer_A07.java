import java.io.*;
import java.net.*;

public class java_28751_SocketServer_A07 {
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is running on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            // Create a buffered reader and writer for the client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read the username and password from the client
            String clientUsername = in.readLine();
            String clientPassword = in.readLine();

            // Authenticate the client
            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                out.println("Authentication successful");
            } else {
                out.println("Authentication failed");
                continue;
            }

            // Communicate with the client
            String message = in.readLine();
            System.out.println("Client says: " + message);

            // Close the connection
            out.close();
            in.close();
            socket.close();
        }
    }
}