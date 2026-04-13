import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_16856_SocketServer_A08 {
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = { 
        'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', 's', '!' };

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesCount = inputStream.read(buffer);
            byte[] encryptedData = encryptData(buffer, bytesCount);
            outputStream.write(encryptedData);

            socket.close();
        }
    }

    private static byte[] encryptData(byte[] data, int length) {
        SecretKeySpec secretKey = new SecretKeySpec(keyValue, ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data, 0, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}