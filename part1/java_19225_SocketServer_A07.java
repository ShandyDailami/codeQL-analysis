import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_19225_SocketServer_A07 {

    private static final String HASH_ALGORITHM = "SHA-256";

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port: " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Authentication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Read client's password
            String password = in.readLine();
            String clientPassword = hashPassword(password);

            // Read server's password
            String serverPassword = in.readLine();

            if (clientPassword.equals(serverPassword)) {
                out.writeBytes("Connection successful\n");
            } else {
                out.writeBytes("Authentication failed\n");
                clientSocket.close();
                continue;
            }

            // Read and echo back the message
            String message = in.readLine();
            out.writeBytes(message + "\n");

            clientSocket.close();
        }
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] hash = digest.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}