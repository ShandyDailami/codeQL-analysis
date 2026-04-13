import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.Key;
import java.security.SecureRandom;

public class java_31268_SocketServer_A01 {
    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 256;

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("AES");
        keyPairGenerator.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(4444, null, null, null, true);
        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

        OutputStream out = clientSocket.getOutputStream();
        InputStream in = clientSocket.getInputStream();

        // generate public and private key
        KeyPair keys = generateKeyPair();

        // generate cipher and decrypt cipher
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keys.getPrivate());
        byte[] encrypted = cipher.doFinal("Enter the data you want to encrypt".getBytes());

        // send encrypted data to the client
        out.write(encrypted);
        out.close();

        // receive encrypted data from the client
        byte[] encryptedData = new byte[1024];
        int bytesRead = in.read(encryptedData);
        if (bytesRead < 0)
            throw new IOException("Error reading stream");

        // decrypt data
        Cipher cipher2 = Cipher.getInstance(ALGORITHM);
        cipher2.init(Cipher.DECRYPT_MODE, keys.getPublic());
        byte[] decrypted = cipher2.doFinal(encryptedData);

        System.out.println("Decrypted data: " + new String(decrypted));

        clientSocket.close();
    }

    private static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("AES");
        keyPairGenerator.initialize(KEY_SIZE);
        return keyPairGenerator.generateKeyPair();
    }
}