import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_00637_SocketServer_A08 {
    private static final String key = "a secret key";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            byte[] readBytes = new byte[100];
            dis.readFully(readBytes);

            // Decrypt the message
            byte[] decrypted = decrypt(readBytes, key);

            String message = new String(decrypted);
            System.out.println("Received: " + message);

            dos.writeBytes("Message received");
            dos.flush();

            socket.close();
        }
    }

    private static byte[] decrypt(byte[] data, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }
}