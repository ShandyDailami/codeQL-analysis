import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import java.security.Key;

public class java_41663_SocketServer_A07 {
    private static final String SSL_KEY_ALIAS = "SSL_KEY_ALIAS";
    private static final String OUTPUT_KEY = "The quick brown fox jumps over the lazy dog"; // This will be used to encrypt/decrypt the data

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        Socket socket = null;

        System.out.println("Waiting for client on port " + sslServerSocketFactory.getPort());

        // Create a SSLServerSocket
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(sslServerSocketFactory.getPort());
        sslServerSocket.setNeedClientAuthentication(true);

        Key key = generateKey();

        // Setup SSLContext with client auth
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new Key[] { key }, null);

        // Create a new socket object
        socket = sslServerSocket.accept();
        socket.setSoTimeout(60000);

        // Setup a new SSL socket
        SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(socket);

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

        // Send ACK back to client
        out.writeBytes("ACK\n");

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("Received: " + line);
            // Encrypt the line before sending it back
            String encryptedLine = encrypt(line, OUTPUT_KEY);
            out.writeBytes(encryptedLine + "\n");
        }

        sslSocket.close();
    }

    private static Key generateKey() throws Exception {
        Key key = null;
        KeyFactory keyFactory = KeyFactory.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(OUTPUT_KEY.getBytes(), "AES");
        key = keyFactory.generatePrivate(secretKeySpec);
        return key;
    }

    private static String encrypt(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return new String(encryptedData);
    }
}