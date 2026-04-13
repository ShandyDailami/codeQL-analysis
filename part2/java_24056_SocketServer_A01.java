import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_24056_SocketServer_A01 {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "/ECB/PKCS5Padding";
    private static final SecretKey key = new SecretKeySpec("KeyForAES128".getBytes(), ALGORITHM);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received message: " + message);

            String encryptedMessage = encryptMessage(message);
            dataOutputStream.writeUTF(encryptedMessage);

            socket.close();
        }
    }

    private static String encryptMessage(String message) throws IOException {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return new String(cipher.doFinal(message.getBytes()));
    }
}