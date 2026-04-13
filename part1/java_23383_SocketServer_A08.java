import java.io.*;
import java.net.*;
import java.security.*;

public class java_23383_SocketServer_A08 {
    private static final String HOST = "localhost";
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        KeyPair kp = kpg.generateKeyPair();

        SSLServerSocket sslServerSocket = new SSLServerSocket(PORT, null, kp.getPrivate(), (PrivateKey) kp.getPublic());
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        DataOutputStream writer = new DataOutputStream(sslSocket.getOutputStream());

        String message = reader.readLine();
        System.out.println("Received: " + message);

        String encryptedMessage = encrypt(message);
        writer.writeBytes(encryptedMessage + "\n");
        writer.flush();

        sslSocket.close();
    }

    private static String encrypt(String message) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, (PrivateKey) cipher.getParameters().getKey());
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return new String(encryptedBytes);
    }
}