import java.io.*;
import java.net.*;
import java.util.*;

public class java_00736_SocketServer_A07 {
    private static final String AUTH_FAILURE = "A07_AuthFailure";
    private static final String USER_AUTHENTICATED = "User authenticated";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read username and password from client
            String username = in.readUTF();
            String password = in.readUTF();

            // Authenticate the user (This is a simple example, you should use actual authentication)
            if (authenticate(username, password)) {
                out.writeUTF(USER_AUTHENTICATED);
            } else {
                out.writeUTF(AUTH_FAILURE);
            }

            out.close();
            client.close();
        }
    }

    // This is a simple example of authentication. You should use actual authentication.
    private static boolean authenticate(String username, String password) {
        // Simple authentication: only allow "admin"
        return username.equals("admin") && password.equals("password");
    }
}