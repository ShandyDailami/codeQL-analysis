import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_22203_SocketServer_A08 {
    private static final int PORT = 12345;
    private static final String ALGORITHM = "AES";

    // Generate a secret key for encryption
    private SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey;
    }

    // Encrypt and decrypt data
    private String encrypt(String data, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return new String(cipher.doFinal(data.getBytes()));
    }

    private String decrypt(String data, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(data.getBytes()));
    }

    public void startServer() throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        SecretKey secretKey = generateKey();

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Receive data from client
            Scanner scanner = new Scanner(inputStream);
            String receivedData = scanner.nextLine();

            // Encrypt received data
            String encryptedData = encrypt(receivedData, secretKey);

            // Send encrypted data to client
            outputStream.write(encryptedData.getBytes());

            // Close connection
            socket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new SocketServer().startServer();
    }
}