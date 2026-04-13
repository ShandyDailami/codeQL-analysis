import java.io.*;
import java.net.*;
import java.util.*;

public class java_21296_SocketServer_A07 {
    private static ArrayList<String> validUsers = new ArrayList<String>(Arrays.asList("user1", "user2", "user3"));
    private static String serverMessage = "";

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            server = new ServerSocket(1234);
            System.out.println("Waiting for client on port: " + server.getLocalPort());
            socket = server.accept();
            System.out.println("Connected with client at: " + socket.getRemoteSocketAddress());

            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            // Authenticate the user
            String user = dis.readUTF();
            if (isUserValid(user)) {
                serverMessage = "Welcome " + user + "! Authentication successful.";
            } else {
                serverMessage = "Invalid username or password.";
            }

            // Send response back to client
            dos.writeUTF(serverMessage);
            dos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
                if (dos != null) dos.close();
                if (socket != null) socket.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isUserValid(String user) {
        return validUsers.contains(user);
    }
}