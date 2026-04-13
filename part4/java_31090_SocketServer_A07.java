import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_31090_SocketServer_A07 {
    private static final String KEY = "AES-GCM";
    private static final byte[] AES_KEY = "12345678abcdefgh".getBytes(); // 32 byte key

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            handleRequest(socket);
        }
    }

    private static void handleRequest(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        // Read username and password
        byte[] authBytes = new byte[16];
        in.read(authBytes);

        // Decode the base64 string
        byte[] decodedBytes = Base64.getDecoder().decode(authBytes);

        // Decrypt the password
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(decodedBytes);
            byte[] bytes = md.digest();

            SecretKeySpec skey = new SecretKeySpec(bytes, "AES-GCM");
            Cipher cipher = Cipher.getInstance(KEY, "AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, skey, new GCMParameterSpec(128, bytes));

            byte[] decryptedBytes = cipher.doFinal(decodedBytes);

            // Send the decrypted password back to the client
            out.write(decryptedBytes);

        } catch (NoSuchAlgorithmException | javax.crypto.Cipher.IllegalBlockSizeException | javax.crypto.Cipher.InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}