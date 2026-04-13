import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class java_27186_SocketServer_A07 {
    private static final String AUTH_SERVER = "localhost";
    private static final int AUTH_SERVER_PORT = 1234;

    private static HashMap<String, String> users = new HashMap<>();

    static {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Please enter your username and password");

            // Receive the username and password from the client
            String username = socket.getInputStream().readUTF();
            String password = socket.getInputStream().readUTF();

            if (authenticate(username, password)) {
                out.println("Authentication successful");
            } else {
                out.println("Authentication failed");
            }

            socket.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        }

        try {
            // Attempt to authenticate against the auth server
            Socket authSocket = new Socket(AUTH_SERVER, AUTH_SERVER_PORT);
            PrintWriter authOut = new PrintWriter(authSocket.getOutputStream(), true);
            authOut.println(username);
            authOut.println(password);

            if ("OK".equals(authSocket.getInputStream().readUTF())) {
                authSocket.close();
                return true;
            }

            authSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}