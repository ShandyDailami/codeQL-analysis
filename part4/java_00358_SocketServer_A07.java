import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_00358_SocketServer_A07 {
    private static Map<String, String> users = new HashMap<>();
    private static String[] userNames = {"Alice", "Bob", "Charlie", "David"};
    private static String[] userPasswords = {"password", "password", "password", "password"};

    static {
        for (int i = 0; i < userNames.length; i++) {
            MessageDigest digest = null;
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            digest.update(userNames[i].getBytes());
            String passwordHash = Arrays.toString(digest.digest(userPasswords[i].getBytes()));
            users.put(userNames[i], passwordHash);
        }
    }

    public static boolean authenticate(String user, String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        digest.update(user.getBytes());
        String userHash = Arrays.toString(digest.digest(password.getBytes()));
        return userHash.equals(users.get(user));
    }

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected!");

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                String request = inputStream.readUTF();
                String[] requestParts = request.split(" ");

                if (requestParts.length != 3 || !requestParts[0].equals("AUTH")) {
                    outputStream.writeUTF("ERROR: Incorrect request format");
                    outputStream.close();
                    continue;
                }

                if (!authenticate(requestParts[1], requestParts[2])) {
                    outputStream.writeUTF("ERROR: Incorrect username or password");
                } else {
                    outputStream.writeUTF("SUCCESS: Authentication successful");
                }

                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}