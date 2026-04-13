import java.io.*;
import java.net.*;
import java.util.Base64;

public class java_02009_SocketServer_A07 {
    private static final String PASSWORD = "password"; // This should be an encrypted password

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        while (true) {
            Socket socket = server.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            if (authenticate(message)) {
                out.writeUTF("Authentication successful!");
            } else {
                out.writeUTF("Authentication failed!");
            }
            socket.close();
        }
    }

    private static boolean authenticate(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(password.getBytes());
            return PASSWORD.equals(Base64.getEncoder().encodeToString(digest));
        } catch (Exception e) {
            return false;
        }
    }
}