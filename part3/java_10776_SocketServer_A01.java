import java.net.*;
import java.io.*;
import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_10776_SocketServer_A01 {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "_ECB";
    private SecretKey key;

    public java_10776_SocketServer_A01() throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
        kgen.init(128); // AES requires a 128-bit key
        key = kgen.generateKey();
    }

    public byte[] encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }

    public String decrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(data));
    }

    public static void main(String[] args) {
        try {
            SecureServer server = new SecureServer();
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                byte[] bytes = new byte[1024];
                int l = dis.read(bytes);
                byte[] encrypted = server.encrypt(new String(bytes, 0, l));
                dos.write(encrypted);
                dos.flush();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}