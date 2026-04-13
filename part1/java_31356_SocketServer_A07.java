import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class java_31356_SocketServer_A07 {
    private static final String AUTH_SUCCESS = "AuthSuccess";
    private static final String AUTH_FAILURE = "AuthFailure";
    private static final String AES_KEY = "AES_KEY"; // Must be 16 bytes

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String authResult = authenticate(in.readUTF());

            out.writeUTF(authResult);
            out.flush();

            socket.close();
        }
    }

    private static String authenticate(String username) throws Exception {
        String password = new String(Base64.getDecoder().decode(username));
        byte[] aesKeyBytes = AES_KEY.getBytes();

        SecretKey key = new SecretKeySpec(aesKeyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedPasswordBytes = cipher.doFinal(password.getBytes());

        String encryptedPassword = Base64.getEncoder().encodeToString(encryptedPasswordBytes);

        return (password.equals(encryptedPassword)) ? AUTH_SUCCESS : AUTH_FAILURE;
    }
}