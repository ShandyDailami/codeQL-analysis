import java.io.*;
import java.net.*;
import java.util.*;

public class java_09333_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started.");

        while (true) {
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected.");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String clientUsername = input.readUTF();
                String clientPassword = input.readUTF();

                if (authenticate(clientUsername, clientPassword)) {
                    output.writeUTF("Authentication successful.");
                } else {
                    output.writeUTF("Authentication failed.");
                }
            } catch (Exception e) {
                System.out.println("Client disconnected.");
            }
        }
    }

    private static boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}