import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_10379_SocketServer_A08 {
    private static final String TRANSPORT_PROTOCOL = "A08_IntegrityFailure";
    private static final String KEY = "1234567890123456"; // use a real secret key

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        while (true) {
            Socket socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Get the client's request
            String request = dis.readUTF();
            System.out.println("Received: " + request);

            // Encrypt the request
            byte[] encrypted = encrypt(request, KEY);

            // Send the encrypted request
            dos.writeUTF(new String(encrypted));
            dos.flush();
       
            socket.close();
        }
    }

    public static byte[] encrypt(String message, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(message.getBytes());
    }
}