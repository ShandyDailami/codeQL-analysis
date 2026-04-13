import java.io.*;
import java.net.*;
import java.util.*;

public class java_07486_SocketServer_A07 {
    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");
    private static String[] validPasswords = {"password1", "password2", "password3"};

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server started...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected...");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientInput = in.readUTF();
                String[] credentials = clientInput.split(":");
                String user = credentials[0];
                String password = credentials[1];

                if (isValidUser(user, password)) {
                    out.writeUTF("Connection successful");
                } else {
                    out.writeUTF("Invalid username or password");
                }

                out.close();
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean isValidUser(String user, String password) {
        return validUsers.contains(user) && validPasswords[validUsers.indexOf(user)].equals(password);
    }
}