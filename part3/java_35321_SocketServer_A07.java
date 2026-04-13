import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35321_SocketServer_A07 {
    private static final String AUTH_USERNAME = "admin";
    private static final String AUTH_PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected");

                authenticateClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void authenticateClient(Socket client) {
        String clientUsername = client.getInetAddress().getHostName();
        String clientPassword = getClientPassword(client);

        if (AUTH_USERNAME.equals(clientUsername) && AUTH_PASSWORD.equals(clientPassword)) {
            System.out.println("Client authenticated successfully");
        } else {
            try {
                client.close();
                System.out.println("Authentication failed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getClientPassword(Socket client) {
        // This is a simple password retrieval example. In a real-world scenario,
        // the password should be securely sent and stored, and not hard-coded here.
        // You should also consider other security measures, like SSL for data transfer.
        return "password";
    }
}