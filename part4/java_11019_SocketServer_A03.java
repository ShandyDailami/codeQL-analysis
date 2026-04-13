import java.io.*;
import java.net.*;
import java.util.*;

public class java_11019_SocketServer_A03 {
    private static List<String> usernames = Arrays.asList("John", "Jane", "Alice", "Bob", "Admin");
    private static List<String> passwords = Arrays.asList("password1", "password2", "Admin");

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started...");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("New connection established from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String username = in.readUTF();
                String password = in.readUTF();

                if (authenticate(username, password)) {
                    out.writeUTF("Successful login!");
                } else {
                    out.writeUTF("Failed login!");
                }

                out.close();
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static boolean authenticate(String username, String password) {
        if (username == null) return false;

        if ("Admin".equals(username) && "Admin".equals(password)) {
            return true;
        }

        if (usernames.contains(username) && passwords.contains(password)) {
            return true;
        }

        return false;
    }
}