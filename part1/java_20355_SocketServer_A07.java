import java.io.*;
import java.net.*;
import java.util.*;

public class java_20355_SocketServer_A07 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at port 8189.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read username and password from client
            String username = in.readUTF();
            String password = in.readUTF();

            // Authenticate user
            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                out.writeUTF("Authentication successful.");
            } else {
                out.writeUTF("Authentication failed.");
            }

            out.close();
            socket.close();
        }
    }
}