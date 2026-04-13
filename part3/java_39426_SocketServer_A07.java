import java.io.*;
import java.net.*;
import java.util.*;

public class java_39426_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected...");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientUsername = dis.readUTF();
            String clientPassword = dis.readUTF();

            if (authenticate(clientUsername, clientPassword)) {
                dos.writeUTF("Authentication successful!");
                dos.flush();
            } else {
                dos.writeUTF("Authentication failed!");
                dos.flush();
            }

            socket.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}