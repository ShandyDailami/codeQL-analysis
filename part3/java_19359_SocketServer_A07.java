import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_19359_SocketServer_A07 {
    private static final String KEY = "ThisIsASecretKey";

    public static SecretKey generateKey() {
        return new SecretKeySpec(KEY.getBytes(), 0, KEY.getBytes().length, "AES");
    }

    public static String encrypt(String data, SecretKey key) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(data.getBytes());
            return new String(cipherText);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String data, SecretKey key) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] cipherText = data.getBytes();
            return new String(cipher.doFinal(cipherText));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server is listening on port 5000...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client is connected...");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            SecretKey key = generateKey();

            String message = in.readLine();
            String encryptedMessage = encrypt(message, key);
            out.writeBytes(encryptedMessage + "\n");

            out.close();
            socket.close();
        }
    }
}