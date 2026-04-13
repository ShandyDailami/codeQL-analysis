import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_11524_SocketServer_A07 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "/ECB/PKCS5Padding";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        while (true) {
            Socket socket = serverSocket.accept();
            handle(socket);
        }
    }

    private static void handle(Socket socket) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        SecretKey key = getKey();
        Cipher cipher = getCipher();

        CipherInputStream cis = new CipherInputStream(reader, cipher);
        CipherOutputStream cos = new CipherOutputStream(writer, cipher);

        // Encrypt and send the data.
        int data;
        while ((data = cis.read()) != -1) {
            cos.write(data);
        }

        cis.close();
        cos.close();
    }

    private static SecretKey getKey() throws Exception {
        // Use your own secret key
        String keyString = "abc123def456";
        return new SecretKeySpec(keyString.getBytes(), ALGORITHM);
    }

    private static Cipher getCipher() throws Exception {
        return Cipher.getInstance(TRANSFORMATION);
    }
}