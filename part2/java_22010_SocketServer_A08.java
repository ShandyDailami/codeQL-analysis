import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_22010_SocketServer_A08 {
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final String KEY = "12345678abcdefgh"; // 128 bit key

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started. Waiting for connections...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            byte[] encryptedData = dis.readUTF().getBytes();
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKey key = new SecretKeySpec(KEY.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            dos.writeUTF(new String(decryptedData));
            dos.flush();

            socket.close();
       
        }
    }
}