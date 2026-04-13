import java.io.*;
import java.net.*;
import java.util.*;

public class java_30732_SocketServer_A03 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started with port number: " + server.getLocalPort());

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new client has connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Get client's username and password
            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();

            // Check if the client's username and password are correct
            if (!clientUsername.equals(USERNAME) || !clientPassword.equals(PASSWORD)) {
                out.writeUTF("Error: Incorrect username or password");
            } else {
                out.writeUTF("Successfully connected");
            }

            socket.close();
        }
    }
}