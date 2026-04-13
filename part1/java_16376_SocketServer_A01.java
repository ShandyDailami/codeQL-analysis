import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16376_SocketServer_A01 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Read username and password from client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientUsername = reader.readLine();
                String clientPassword = reader.readLine();

                // Check if username and password match
                if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                    System.out.println("Access granted for user " + clientUsername);

                    // Send a welcome message to the client
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("Welcome, user " + clientUsername + ". You are now connected.");
                } else {
                    System.out.println("Access denied for user " + clientUsername);
                    writer.println("Access denied for user " + clientUsername);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}