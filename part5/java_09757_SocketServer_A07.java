import java.io.*;
import java.net.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_09757_SocketServer_A07 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "/ECB/PKCS5Padding";

    private static SecretKeySpec getKey(String password) throws Exception {
        byte[] key = password.getBytes();
        return new SecretKeySpec(key, ALGORITHM);
    }

    private static String encrypt(String data, SecretKeySpec key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes("UTF-8")));
    }

    private static String decrypt(String data, SecretKeySpec key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }

    public static void main(String[] args) throws Exception {
        String password = "myPassword";
        SecretKeySpec key = getKey(password);

        ServerSocket serverSocket = new ServerSocket(1234);
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readLine();
            String encryptedMessage = encrypt(message, key);
            out.writeUTF(encryptedMessage);

            out.close();
            socket.close();
        }
    }
}