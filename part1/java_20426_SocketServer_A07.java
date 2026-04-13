import java.net.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_20426_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        while (true) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMsg = in.readLine();
            String[] clientCreds = clientMsg.split(" ");
            String clientUser = clientCreds[0];
            String clientPass = clientCreds[1];

            if (isValid(clientUser, clientPass)) {
                out.writeBytes("Authentication successful\n");
            } else {
                out.writeBytes("Authentication failed\n");
            }
            socket.close();
        }
    }

    private static boolean isValid(String username, String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString().equals(USERNAME);
    }
}