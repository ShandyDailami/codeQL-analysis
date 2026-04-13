import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_05532_SocketServer_A08 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "/ECB/NoPadding";
    private static final SecretKey key = new SecretKeySpec("ThisKeyIsUsedOnlyBySymmetricAlgorithms".getBytes(), ALGORITHM);

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            String response = new StringBuilder(message).reverse().toString();

            out.writeUTF(encrypt(response));
            socket.close();
        }
    }

    private static String encrypt(String message) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return new String(cipher.doFinal(message.getBytes()));
    }
}