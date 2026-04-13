import java.io.*;
import java.net.*;
import javax.crypto.*;

public class java_31229_SocketServer_A08 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final SecretKey KEY = new SecretKey(); // Generate a SecretKey

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Encrypt the client's message
            String message = in.readUTF();
            byte[] encrypted = encrypt(message);

            // Send the encrypted message
            out.writeUTF(new String(encrypted));

            socket.close();
        }
    }

    private static byte[] encrypt(String message) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, KEY);

        return cipher.doFinal(message.getBytes());
    }
}