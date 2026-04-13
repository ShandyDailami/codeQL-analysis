import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38443_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected...");

                // Perform authentication
                authenticateClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void authenticateClient(Socket socket) {
        try {
            // Read username and password from client
            socket.getInputStream().readUTF();
            String username = socket.getInputStream().readUTF();
            String password = socket.getInputStream().readUTF();

            if (!username.equals(USERNAME) || !password.equals(PASSWORD)) {
                throw new SecurityException("Authentication failed");
            }

            // Authentication successful, send response
            socket.getOutputStream().writeUTF("Authentication successful");

        } catch (IOException e) {
            e.printStackTrace();
        // Handle IOException here
        }
    }
}