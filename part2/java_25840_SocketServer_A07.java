import java.io.*;
import java.net.*;
import java.util.*;

public class java_25840_SocketServer_A07 {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private static boolean isAuthorized(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            String[] parts = request.split(" ");

            if (isAuthorized(parts[1], parts[2])) {
                out.writeUTF("Welcome, " + parts[1]);
            } else {
                out.writeUTF("Authentication failed");
            }

            socket.close();
        }
    }
}