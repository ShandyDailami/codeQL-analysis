import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class java_07976_SocketServer_A07 {
    private static HashMap<String, String> credentials = new HashMap<>();

    static {
        credentials.put("admin", "password");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        while (true) {
            Socket client = server.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Connected to the server");
            String username = client.getInputStream().readUTF();
            String password = client.getInputStream().readUTF();
            if (authenticate(username, password)) {
                out.println("Welcome, " + username + "!");
            } else {
                out.println("Authentication failed");
            }
            client.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        return credentials.get(username).equals(password);
    }
}