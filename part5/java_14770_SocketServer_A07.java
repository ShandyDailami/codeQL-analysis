import java.io.*;
import java.net.*;
import java.util.*;

public class java_14770_SocketServer_A07 {

    private static final int PORT = 12345;
    private static final String AUTH_FAILURE_ERROR = "Authentication failure.";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new client has connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            if (handleAuth(message)) {
                out.writeUTF("Authentication successful.");
            } else {
                out.writeUTF(AUTH_FAILURE_ERROR);
            }

            out.close();
        }
    }

    private static boolean handleAuth(String message) {
        // This is a very basic authentication mechanism. In a real-world application,
        // you would likely use more complex mechanisms like hash-based or token-based
        // authentication to protect sensitive operations.
        return message.equals("username") && message.equals("password");
    }
}