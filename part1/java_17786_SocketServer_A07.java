import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_17786_SocketServer_A07 {
    private static Map<String, String> credentials = new HashMap<>();
    private static final String AUTHENTICATION_FAILURE = "A07_AuthFailure";

    static {
        // Add your credentials here. This should be done securely.
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        // etc.
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket client = server.accept();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String username = in.readLine();
            String password = in.readLine();

            if (!authenticate(username, password)) {
                out.println("Authentication failed");
            } else {
                out.println("Authentication successful");
            }

            client.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        String expectedPassword = credentials.get(username);

        if (expectedPassword == null) {
            return false;
        }

        // This is a very basic authentication mechanism. It's not secure for real applications.
        // In a real application, you would want to use a secure mechanism, like password hashing.
        return expectedPassword.equals(password);
    }
}