import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class java_05972_SocketServer_A07 {

    private static final String AES = "AES";
    private static final int KEY_SIZE = 16;
    private static final String SECRET_KEY = "a secret key";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            byte[] decodedBytes = Base64.getDecoder().decode(message);

            Cipher cipher = Cipher.getInstance(AES);
            SecretKey secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), AES);

            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);

            String decryptedMessage = new String(decryptedBytes, "UTF-8");

            out.writeUTF(decryptedMessage);
            out.flush();
        }
    }
}