import java.net.*;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_11675_SocketServer_A08 {

    private static final String AES = "AES";
    private static final String KEY = "12345678abcdefgh"; // 128 bit key

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Receive the AES encrypted request
            byte[] encryptedRequest = dis.readByteArray();

            // Decrypt the request
            byte[] decryptedRequest = decrypt(encryptedRequest, KEY);
            System.out.println("Received message: " + new String(decryptedRequest));

            // Send the response
            dos.writeBytes("Server received the message!");

            dos.close();
            socket.close();
       
        }
    }

    private static byte[] decrypt(byte[] encryptedText, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedText);
    }
}