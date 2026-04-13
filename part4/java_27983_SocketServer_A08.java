import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_27983_SocketServer_A08 {
    private static final String KEY = "a secret key"; // Replace with your own secret key

    public static Key getKey() throws NoSuchAlgorithmException {
        return new SecretKeySpec(KEY.getBytes(), 0, KEY.getBytes().length, "AES");
    }

    public static String encrypt(String data, Key key) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return new String(cipher.doFinal(data.getBytes()));
    }

    public static String decrypt(String data, Key key) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(data.getBytes()));
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Key key = getKey();

            String message = in.readLine();
            System.out.println("Received: " + message);

            String encryptedMessage = encrypt(message, key);
            out.writeBytes(encryptedMessage + "\n");

            out.close();
            socket.close();
        }
    }
}