import java.io.*;
import java.net.*;
import java.util.*;

public class java_09597_SocketServer_A07 {
    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            String user = input.readUTF();

            if (isValidUser(user)) {
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF("Connection successful.");
            } else {
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF("Invalid username or password.");
            }

            socket.close();
        }
    }

    private static boolean isValidUser(String user) {
        return validUsers.contains(user);
    }
}