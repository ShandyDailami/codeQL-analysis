import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_23332_SocketServer_A08 {

    private static final String key = "a secret kick ass";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String messageFromClient;
            if ((messageFromClient = in.readLine()) != null) {
                if (messageFromClient.equals("close")) {
                    out.println("Connection closed");
                    clientSocket.close();
                } else {
                    String decrypted = decrypt(messageFromClient, key);
                    out.println("Server received: " + decrypted);
                }
            }
            clientSocket.close();
        }
    }

    private static String decrypt(String data, String key) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            System.out.println("Error decrypting: " + e.toString());
        }
        return null;
    }
}