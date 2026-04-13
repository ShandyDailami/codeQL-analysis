import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class java_14864_SocketServer_A07 {
    private static final String KEY = "1234567890123456"; // 16 bytes key
    private static final SecretKey secretKey = new SecretKeySpec(KEY.getBytes(), "AES");

    public static void handleClient(Socket client) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

        String message;
        while ((message = reader.readLine()) != null) {
            if (message.equals("exit")) {
                break;
            }
            String encryptedMessage = encrypt(message);
            writer.println(encryptedMessage);
        }
        writer.close();
        client.close();
    }

    public static String encrypt(String data) {
        byte[] encrypted = null;
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            encrypted = cipher.doFinal(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(Base64.getEncoder().encode(encrypted));
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected");
            new Thread(new Runnable() {
                public void run() {
                    try {
                        handleClient(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}