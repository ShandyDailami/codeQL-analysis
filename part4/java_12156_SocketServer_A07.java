import java.io.*;
import java.net.*;
import java.util.*;

public class java_12156_SocketServer_A07 {
    private static final String PASSWORD_HASH = "MD5";
    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);

        while (true) {
            Socket socket = server.accept();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Client: " + clientMessage);

            String user = clientMessage.split(" ")[0];
            String pass = clientMessage.split(" ")[1];

            if (verifyUser(user, pass)) {
                dos.writeUTF("Access granted");
            } else {
                dos.writeUTF("Access denied");
            }

            dos.close();
            socket.close();
        }
    }

    private static boolean verifyUser(String user, String pass) {
        String hashedPass = hashPassword(pass);
        return credentials.get(user).equals(hashedPass);
    }

    private static String hashPassword(String password) {
        // This is a simplistic hashing function. You should use a real hashing function for production use.
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(password.getBytes());
        return bytesToHex(hashBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}