import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_23421_SocketServer_A08 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "_CBC";

    private Key key;
    private Cipher cipher;

    public java_23421_SocketServer_A08(int port) throws Exception {
        key = generateKey();
        cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String request = in.readUTF();
            byte[] encryptedRequest = encryptRequest(request);
            out.writeUTF(new String(encryptedRequest));
            out.flush();
            socket.close();
        }
    }

    private byte[] encryptRequest(String request) throws Exception {
        byte[] data = request.getBytes();
        byte[] iv = new byte[16];
        System.arraycopy(data, 0, iv, 0, data.length);
        byte[] encryptedData = cipher.doFinal(data);
        return ByteUtils.combine(iv, encryptedData);
    }

    private Key generateKey() throws Exception {
        return new SecretKeySpec("ThisIsAESEncryption".getBytes(), ALGORITHM);
    }

    public static void main(String[] args) {
        try {
            new SocketServer(8080);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ByteUtils {
    public static byte[] combine(byte[] b1, byte[] b2) {
        byte[] c = new byte[b1.length + b2.length];
        System.arraycopy(b1, 0, c, 0, b1.length);
        System.arraycopy(b2, 0, c, b1.length, b2.length);
        return c;
    }
}