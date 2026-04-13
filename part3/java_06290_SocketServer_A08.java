import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_06290_SocketServer_A08 {
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Generate secret key
            Key key = KeyGenerator.getInstance(ALGORITHM).generateKey();
            SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);

            // Encrypt the message
            String message = in.readUTF();
            byte[] encryptedMessage = encrypt(message, secretKey);

            // Send encrypted message to the client
            out.writeUTF(new String(encryptedMessage));
            out.flush();

            socket.close();
        }
    }

    private static byte[] encrypt(String message, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(message.getBytes());
    }
}