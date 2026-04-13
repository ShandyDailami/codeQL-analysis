import java.io.*;
import java.net.*;
import javax.crypto.*;

public class java_02438_SocketServer_A07 {
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started!");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String password = in.readUTF();
            if (checkPassword(password)) {
                out.writeUTF("Access granted");
            } else {
                out.writeUTF("Access denied");
           
            }

            socket.close();
        }
    }

    private static boolean checkPassword(String password) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String encryptedPassword = getEncryptedPassword(password);
        return encryptedPassword.equals(getEncryptedPassword(PASSWORD));
    }

    private static String getEncryptedPassword(String password) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Key key = KeyGenerator.getInstance("AES").generateKey();
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, key);
        return new String(cipher.doFinal(password.getBytes()));
    }
}