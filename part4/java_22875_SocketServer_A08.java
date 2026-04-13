import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_22875_SocketServer_A08 {
    // Encryption key
    private static final byte[] key = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + 8189);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Encrypt client's data
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            byte[] bytes = new byte[1024];
            in.readFully(bytes);

            // Decrypt data
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(bytes);

            System.out.println("Decrypted data: " + new String(decryptedData));

            out.writeUTF("Thank you for connecting");
            out.flush();

            socket.close();
        }
    }
}