import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_21774_SocketServer_A08 {

    private static final String KEY = "A super secret key"; // you should replace this with a real key

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for connection...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            // Receive message
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Encrypt message
            byte[] encrypted = encrypt(message, KEY);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(new String(encrypted));

            socket.close();
        }
    }

    private static byte[] encrypt(String message, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(message.getBytes());
    }
}