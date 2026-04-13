import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class java_41333_SocketServer_A07 {

    private static final String CORRECT_USERNAME = "user";
    private static final String CORRECT_PASSWORD = "pass";
    private static final String CORRECT_IP = "127.0.0.1";

    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("user", "pass");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started!");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientIP = socket.getInetAddress().getHostAddress();
            String clientUsernameAndPassword = in.readUTF();

            String[] usernameAndPassword = clientUsernameAndPassword.split(":");

            if (clientIP.equals(CORRECT_IP) &&
                    users.get(usernameAndPassword[0]).equals(usernameAndPassword[1])) {
                out.writeUTF("Connection successful");
            } else {
                out.writeUTF("Invalid username or password");
            }

            socket.close();
        }
    }
}