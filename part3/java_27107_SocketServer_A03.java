import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class java_27107_SocketServer_A03 {
    private static HashMap<String, String> users = new HashMap<>();

    static {
        users.put("admin", "password");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189, 10000);
        System.out.println("Server started on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client is connected");

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Connected to the server");

            String clientMessage = socket.getInputStream().readUTF();
            System.out.println("Client says: " + clientMessage);

            String response = validateUser(clientMessage);
            writer.println(response);
        }
    }

    private static String validateUser(String clientMessage) {
        String[] userDetails = clientMessage.split(":");
        String username = userDetails[0];
        String password = userDetails[1];

        String dbPassword = users.get(username);

        if (dbPassword != null && dbPassword.equals(password)) {
            return "Login successful";
        } else {
            return "Login failed";
        }
    }
}