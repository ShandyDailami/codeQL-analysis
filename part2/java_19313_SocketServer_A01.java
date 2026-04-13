import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class java_19313_SocketServer_A01 {
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "12345678abcdefgh".getBytes();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port 8189...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            byte[] msg = dis.readUTF().getBytes();
            byte[] encrypted = encrypt(msg, keyValue);
            dos.writeUTF(new String(encrypted));
            dos.flush();

            socket.close();
        }
    }

    private static byte[] encrypt(byte[] bytesToEncrypt, byte[] secretKey) {
        try {
            Key key = new SecretKeySpec(secretKey, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(bytesToEncrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}