import java.io.*;
import java.net.*;
import java.util.*;

public class java_38787_SocketServer_A07 {

    private static ArrayList<String> authorizedUsers = new ArrayList<>(Arrays.asList("user1", "user2", "user3"));
    private static String USERNAME = "user1";
    private static String PASSWORD = "password1";

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // create server socket
            server = new ServerSocket(6666);
            System.out.println("Waiting for client on port " + server.getLocalPort() + "...");

            // accept client
            socket = server.accept();
            System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

            // receive and process message
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            if (authenticateUser(clientMessage)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
            }

            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateUser(String user) {
        String[] splitUser = user.split(":");
        String providedUsername = splitUser[0];
        String providedPassword = splitUser[1];

        if (providedUsername.equals(USERNAME) && providedPassword.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}