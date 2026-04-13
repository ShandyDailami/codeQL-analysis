import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_08355_SocketServer_A08 {
    private static final String KEY = "AESExampleKey";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Waiting for client...");

        // Create AES encryption
        SecretKey aesKey = new SecretKeySpec(KEY.getBytes(), "AES");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Receive message
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Encrypt message
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encryptedMessage = cipher.doFinal(message.getBytes());

            // Send encrypted message
            dos.writeUTF(new String(encryptedMessage));
            dos.flush();

            socket.close();
        }
    }
}