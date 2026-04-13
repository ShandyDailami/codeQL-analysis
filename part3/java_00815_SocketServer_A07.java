import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00815_SocketServer_A07 {
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(4242)) {
            System.out.println("Server started, waiting for connections on port 4242...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected.");

                // Assume that the client sends its username and password as strings
                // This part is not secure, it's for the example, use secure ways for real applications
                String clientUsername = socket.getInputStream().readUTF();
                String clientPassword = socket.getInputStream().readUTF();

                if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                    System.out.println("Authentication successful.");
                    // If authentication is successful, the server accepts the connection
                    socket.getOutputStream().writeUTF("AuthSuccess");
                } else {
                    System.out.println("Authentication failed.");
                    // If authentication fails, the server sends an "AuthFailure" message to the client
                    socket.getOutputStream().writeUTF("AuthFailure");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}