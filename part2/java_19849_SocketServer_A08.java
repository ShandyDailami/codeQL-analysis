import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class java_19849_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started at port 12345");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Generate a 128-bit AES-encrypted key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecretKey key = keyGenerator.generateKey();

            // Create a cipher with the key and AES cipher mode
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getEncoded(), "AES"));

            // Receive data from the client, encrypt it, and send it back
            byte[] data = new byte[1024];
            socket.getInputStream().read(data);
            byte[] encryptedData = cipher.doFinal(data);
            socket.getOutputStream().write(encryptedData);

            socket.close();
        }
    }
}