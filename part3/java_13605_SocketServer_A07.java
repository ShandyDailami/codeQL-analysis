import java.io.*;
import java.net.*;
import java.util.*;

public class java_13605_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication successful";
    private static final String AUTHENTICATION_FAILURE = "Authentication failure";

    private static Map<String, String> credentials = new HashMap<>();

    static {
        // Add some sample credentials for testing
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            System.out.println("Waiting for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Connection accepted from: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the username and password from the client
            String username = in.readUTF();
            String password = in.readUTF();

            // Authenticate the client
            String response;
            if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
                response = AUTHENTICATION_SUCCESS;
            } else {
                response = AUTHENTICATION_FAILURE;
            }

            // Send the authentication result back to the client
            out.writeUTF(response);

            out.close();
            socket.close();
        }
    }
}