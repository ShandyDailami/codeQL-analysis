import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_36112_SocketServer_A08 {

    private static final String key = "AES_KEY"; // you should use a secret key here

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            Key key2 = new SecretKeySpec(key.getBytes(), 0, key.getBytes().length, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key2);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                byte[] decodedBytes = cipher.doFinal(Base64.getDecoder().decode(message));
                System.out.println("Decoded: " + new String(decodedBytes));
                out.writeBytes(message + "\n");
            }
        } finally {
            serverSocket.close();
        }
    }
}