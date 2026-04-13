import java.io.*;
import java.net.*;
import java.util.*;

public class java_23653_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "admin";
    private static final String AUTHENTICATED_PASSWORD = "admin";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();

            if (authenticate(clientUsername, clientPassword)) {
                out.writeUTF("Authentication successful");
                out.flush();
            } else {
                out.writeUTF("Authentication failed");
                out.flush();
            }

            socket.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        return AUTHENTICATED_USER.equals(username) && AUTHENTICATED_PASSWORD.equals(password);
    }
}