import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_38491_SocketServer_A07 {

    private static final String ALGORITHM = "SHA-512";
    private static final int SALT_SIZE = 16;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected...");

            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            byte[] salt = new byte[SALT_SIZE];
            new SecureRandom().nextBytes(salt);

            md.update(salt);
            byte[] hashedPassword = md.digest(socket.getInetAddress().getHostAddress().getBytes());

            // Now use the hashed password for further operations
        }
    }
}