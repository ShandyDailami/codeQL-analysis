import java.io.*;
import java.net.*;
import java.util.Arrays;

public class java_17383_SocketServer_A07 {

    private static String[] validUsers = {"user1", "user2", "user3"};
    private static String[] validPasswords = {"password1", "password2", "password3"};

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            if (authenticate(clientMessage)) {
                out.writeUTF("Authentication successful!");
            } else {
                out.writeUTF("Authentication failed!");
            }

            out.close();
            socket.close();
        }
    }

    private static boolean authenticate(String userPassword) {
        String[] credentials = userPassword.split(":");
        if (Arrays.asList(validUsers).contains(credentials[0])
                && Arrays.asList(validPasswords).contains(credentials[1])) {
            return true;
        }
        return false;
    }
}