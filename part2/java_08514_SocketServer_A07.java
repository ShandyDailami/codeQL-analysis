import java.io.*;
import java.net.*;
import java.util.*;

public class java_08514_SocketServer_A07 {
    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");
    private static List<String> validPasswords = Arrays.asList("pass1", "pass2", "pass3");

    public static boolean authenticate(String user, String password) {
        if (validUsers.contains(user) && validPasswords.contains(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received message: " + clientMessage);

            String user = clientMessage.split(":")[0];
            String password = clientMessage.split(":")[1];

            if (authenticate(user, password)) {
                dataOutputStream.writeUTF("Authentication successful!");
            } else {
                dataOutputStream.writeUTF("Authentication failed!");
            }

            dataOutputStream.close();
            socket.close();
        }
    }
}