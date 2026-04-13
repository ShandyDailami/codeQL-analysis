import java.io.*;
import java.net.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_16641_SocketServer_A07 {
    private static final String SALT = "salt"; // for security reasons, we must use a secure random salt

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientRequest = in.readUTF();
            System.out.println("Received: " + clientRequest);

            String response;
            if (authenticate(clientRequest)) {
                response = "Auth successful";
            } else {
                response = "Auth failed";
            }

            out.writeUTF(response);
            out.close();
            socket.close();
        }
    }

    private static boolean authenticate(String request) throws NoSuchAlgorithmException {
        String hash = getMD5Hash(request, SALT);

        // In real use case, database lookup would occur here.
        // Let's assume it's already done and the hashed request is "expectedHash"
        String expectedHash = "expectedHash";

        return hash.equals(expectedHash);
    }

    private static String getMD5Hash(String input, String salt) throws NoSuchAlgorithmException {
        String toReturn = null;
        String toCheck = null;

        // step 1
        MessageDigest md = MessageDigest.getInstance("MD5");

        // step 2
        md.update(salt.getBytes());

        // step 3
        byte[] bytes = md.digest(input.getBytes());

        // step 4
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        // step 5
        toReturn = sb.toString();
        System.out.println("MD5 hash: " + toReturn);
        return toReturn;
    }
}