import java.io.*;
import java.net.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_17826_SocketServer_A07 {

    private static final String HASH_ALGORITHM = "SHA-256";
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", getHash("password1", HASH_ALGORITHM));
        users.put("user2", getHash("password2", HASH_ALGORITHM));
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);

        System.out.println("Server started on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message = in.readLine();
            System.out.println("Message received: " + message);

            String[] parts = message.split(" ");
            String user = parts[0];
            String password = parts[1];

            String expectedHash = users.get(user);

            String hash = getHash(password, HASH_ALGORITHM);

            if (hash.equals(expectedHash)) {
                out.println("Access granted");
            } else {
                out.println("Access denied");
           .
.
.
.

        }
    }

    public static String getHash(String input, String hashAlgorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(hashAlgorithm);
        byte[] hash = digest.digest(input.getBytes("UTF-8"));

        return bytesToHex(hash);
    }

    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}