import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_10372_SocketServer_A08 {

    private static final String KEY = "A08_IntegrityFailure"; // This is a key used for encryption and decryption

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return new String(cipher.doFinal(data.getBytes()));
    }

    public static String decrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(data.getBytes()));
    }

    public static void handleRequest(Socket socket) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Generate key
        SecretKey key = generateKey();

        // Receive data and encrypt
        String data = in.readLine();
        String encryptedData = encrypt(data, key);
        out.writeBytes(encryptedData + "\n");

        // Decrypt
        String decryptedData = decrypt(encryptedData, key);
        out.writeBytes(decryptedData + "\n");

        socket.close();
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            handleRequest(socket);
        }
    }
}