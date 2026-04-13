import java.io.*;
import java.net.*;
import java.security.*;

public class java_36166_SocketServer_A07 {

    private final static int PORT = 12345;
    private final static String HASH_ALGORITHM = "SHA-256";

    public static void main(String[] args) throws IOException {
        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String username = dataInputStream.readUTF();
            String password = dataInputStream.readUTF();

            String hashedPassword = hashPassword(password, digest);

            if (hashedPassword.equals(dataInputStream.readUTF())) {
                System.out.println("Authentication successful for user: " + username);
                dataOutputStream.writeUTF("Authentication successful");
            } else {
                System.out.println("Authentication failure for user: " + username);
                dataOutputStream.writeUTF("Authentication failure");
           
            }

            dataOutputStream.close();
            socket.close();
        }
    }

    public static String hashPassword(String password, MessageDigest digest) throws NoSuchAlgorithmException {
        byte[] hash = digest.digest(password.getBytes());
        return new String(hash);
    }
}