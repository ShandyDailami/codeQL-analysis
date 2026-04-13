import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class java_27992_SocketServer_A07 {

    private static final String KEY = "12345678abcdefgh";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            byte[] bytes = new byte[1024];
            in.readFully(bytes);

            String message = new String(bytes, "UTF-8");
            System.out.println("Received: " + message);

            byte[] decodedBytes = Base64.getDecoder().decode(message);
            String decodedMessage = new String(decodedBytes, "UTF-8");
            System.out.println("Decoded message: " + decodedMessage);

            Key key = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            String decryptedMessage = new String(decryptedBytes, "UTF-8");
            System.out.println("Decrypted message: " + decryptedMessage);

            out.writeBytes("Thank you for connecting");

            socket.close();
        }
    }
}