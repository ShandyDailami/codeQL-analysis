import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class java_29521_SocketServer_A08 {
    private static final String HMAC_KEY = "hmac_key";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readLine();
            System.out.println("Received: " + message);

            byte[] encryptedMessage = encryptMessage(message);
            out.writeBytes("Encrypted message: " + encryptedMessage + "\n");

            socket.close();
        }
    }

    private static byte[] encryptMessage(String message) throws Exception {
        Key key = KeyGenerator.getInstance("HmacMD5").generateKey();
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(new SecretKeySpec(key, "HmacMD5"));

        byte[] data = message.getBytes();
        byte[] signature = mac.doFinal(data);

        return signature;
    }
}