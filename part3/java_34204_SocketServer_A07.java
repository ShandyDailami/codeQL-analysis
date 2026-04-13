import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class java_34204_SocketServer_A07 {
    private static final String ALGORITHM = "AES";
    private static final SecretKey SECRET_KEY = new SecretKeySpec("abcdefghabcdefgh".getBytes(), ALGORITHM);

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read username
            String username = in.readLine();
            System.out.println("Received username: " + username);

            // Encrypt username
            byte[] encryptedUsername = encrypt(username);
            out.println(new String(encryptedUsername));

            socket.close();
        }
    }

    private static byte[] encrypt(String message) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY);
        return cipher.doFinal(message.getBytes());
    }
}