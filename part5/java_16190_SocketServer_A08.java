import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_16190_SocketServer_A08 {
    private static final String ALGORITHM = "AES";
    private static final SecretKey secretKey = new SecretKeySpec("KeyForAES128".getBytes(), ALGORITHM);

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection accepted from: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message from client: " + message);

            byte[] encryptedData = encrypt(message);
            out.writeUTF(new String(encryptedData));
            out.flush();

            socket.close();
        }
    }

    private static byte[] encrypt(String message) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(message.getBytes());
    }
}