import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_28294_SocketServer_A07 {
    private static final String KEY = "12345678abcdefgh";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Read the request
            DataInputStream input = new DataInputStream(socket.getInputStream());
            String request = input.readUTF();

            // Decrypt the request using AES
            byte[] encryptedData = hexStringToByteArray(request);
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);
            String decryptedRequest = new String(decryptedData);

            // Authenticate the client
            if (decryptedRequest.equals("AUTHENTICATE")) {
                // Send a response
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF("AUTHENTICATED");
            } else {
                // Close the connection
                socket.close();
           
                System.out.println("Client not authenticated");
            }
        }
    }

    private static byte[] hexStringToByteArray(String hexString) {
        int length = hexString.length() / 2;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) ((Character.digit(hexString.charAt(i * 2), 16) << 4)
                    + Character.digit(hexString.charAt(i * 2 + 1), 16));
        }
        return bytes;
    }
}