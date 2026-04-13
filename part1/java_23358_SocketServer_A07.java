import java.io.*;
import java.net.*;
import java.util.*;

public class java_23358_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "admin";
    private static final String AUTHENTICATED_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMsg = in.readUTF();
            System.out.println("Client says: " + clientMsg);

            String user = in.readUTF();
            String password = in.readUTF();

            if (authenticateUser(user, password)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
           
            }

            out.close();
            socket.close();
        }
    }

    private static boolean authenticateUser(String user, String password) {
        return AUTHENTICATED_USER.equals(user) && AUTHENTICATED_PASSWORD.equals(password);
    }
}