import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_22442_SocketServer_A07 {
    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        // Add more users as needed
    }

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Server started on port 8189");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getInetAddress().getHostAddress());

                // Authentication
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                String login = client.getInputStream().readUTF();
                String password = client.getInputStream().readUTF();

                if (!authenticate(login, password)) {
                    out.println("FAILURE");
                    continue;
                }

                out.println("SUCCESS");
            }
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private static boolean authenticate(String login, String password) {
        String expectedPassword = credentials.get(login);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}