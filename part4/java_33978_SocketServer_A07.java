import java.io.*;
import java.net.*;
import java.util.*;

public class java_33978_SocketServer_A07 {

    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");
    private static String decryptedPassword = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started at port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String client = dis.readUTF();
            authenticateClient(socket, client);

            dos.writeUTF("Connection successful");
            dos.flush();
        }
    }

    private static void authenticateClient(Socket socket, String client) throws Exception {
        String[] clientDetails = client.split("-");
        String user = clientDetails[0];
        String password = clientDetails[1];

        if (!isValidUser(user) || !isValidPassword(password)) {
            closeSocket(socket);
            throw new Exception("Authentication failed");
        }
    }

    private static boolean isValidUser(String user) {
        return validUsers.contains(user);
    }

    private static boolean isValidPassword(String password) {
        return password.equals(decryptedPassword);
    }

    private static void closeSocket(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}