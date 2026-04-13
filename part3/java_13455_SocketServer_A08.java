import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_13455_SocketServer_A08 {
    private static final String ALGORITHM = "AES";
    private static SecretKey key;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started");

        key = KeyGenerator.getKey();

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            byte[] buf = new byte[1024];
            in.readFully(buf);
            byte[] encrypted = new byte[buf.length];

            for (int i = 0; i < buf.length; i++) {
                encrypted[i] = (byte)(buf[i] ^ key.getBytes()[i % key.getBytes().length]);
            }

            out.writeBytes(encrypted);
            out.flush();
       
            socket.close();
        }
    }

    public static class KeyGenerator {
        public static SecretKey getKey() throws Exception {
            KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
            keygen.init(128);
            SecretKey key = keygen.generateKey();
            return key;
        }
    }
}