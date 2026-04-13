import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.Key;

public class java_02512_SocketServer_A08 {
    private static final String ALGORITHM = "AES";
    private static final Key key = KeyGenerator.getInstance(ALGORITHM).generateKey();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            byte[] buffer = new byte[1024];
            int length = in.read(buffer);
            byte[] data = new byte[length];
            System.arraycopy(buffer, 0, data, 0, length);

            encryptData(data);
            out.write(data);

            out.close();
            in.close();
            socket.close();
        }
    }

    public static void encryptData(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data);
        // Do something with encryptedData...
    }
}