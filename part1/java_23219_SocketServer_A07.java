import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23219_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "JohnDoe";
    private static final String AUTHENTICATED_PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                Socket client = server.accept();
                authenticateClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void authenticateClient(Socket client) {
        String clientUsername = client.getRemoteSocketAddress().toString();
        String clientPassword = getPassword(clientUsername);

        if (!clientUsername.equals(AUTHENTICATED_USER) || !clientPassword.equals(AUTHENTICATED_PASSWORD)) {
            System.out.println("Authentication failed for " + clientUsername);
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        System.out.println("Authentication successful for " + clientUsername);
        // Perform the rest of the client's request
    }

    private static String getPassword(String username) {
        // Placeholder for actual password retrieval. This would likely involve database calls or other security measures.
        return "password";
    }
}