import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_41065_SocketServer_A07 {
    private static final String AUTH_FAILURE = "Authentication failed";
    private static final String OK = "OK";
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", "password1"); // add users here
        users.put("user2", "password2");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189, 10000);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String response;

            String received = socket.getInputStream().readUTF();

            String[] creds = received.split(" ");
            String user = creds[0];
            String pass = creds[1];

            if (authenticate(user, pass)) {
                response = OK;
            } else {
                response = AUTH_FAILURE;
            }

            writer.println(response);
            socket.close();
        }
    }

    private static boolean authenticate(String user, String pass) {
        String password = users.get(user);

        if (password == null) {
            return false;
        }

        return password.equals(pass);
    }
}