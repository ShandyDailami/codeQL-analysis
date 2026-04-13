import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33119_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "User";
    private static final String AUTHENTICATED_PASSWORD = "Password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                String clientUsername = socket.getRemoteSocketAddress().toString();
                String clientPassword = getClientPassword(socket);

                if (clientUsername.equals(AUTHENTICATED_USER) && clientPassword.equals(AUTHENTICATED_PASSWORD)) {
                    System.out.println("Authenticated user");
                    handleClient(socket);
                } else {
                    System.out.println("Unauthenticated user");
                    closeSocket(socket);
                }
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }

    private static void handleClient(Socket socket) {
        // Handle the client here
    }

    private static void closeSocket(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Error closing socket: " + e.getMessage());
        }
    }

    private static String getClientPassword(Socket socket) {
        // In reality, you would need to handle SSL/TLS for secure password transmission
        // This is a simplistic example for demonstration purposes
        return "Password";
    }
}