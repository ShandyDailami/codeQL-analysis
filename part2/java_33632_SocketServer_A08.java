import java.io.*;
import java.net.*;
import javax.crypto.*;

public class java_33632_SocketServer_A08 {
    public static final int PORT = 1234;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Encryption
            Cipher cipher = Cipher.getInstance("AES");
            SecretKey key = KeyGenerator.createKey();
            cipher.init(Cipher.ENCRYPT_MODE, key);
            String encryptedMessage = new String(cipher.doFinal(message.getBytes()));

            out.writeUTF(encryptedMessage);
            out.flush();

            socket.close();
       
        }
    }
}