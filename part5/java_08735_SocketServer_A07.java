import java.io.*;
import java.net.*;
import java.util.*;

public class java_08735_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    private static boolean authenticate(String user, String password) {
        return USERNAME.equals(user) && PASSWORD.equals(password);
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String username = in.readUTF();
            String password = in.readUTF();

            if (authenticate(username, password)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
            }

            socket.close();
        }
    }
}