import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class java_16925_SocketServer_A03 {

    // The key and initialization vector used for encryption
    private static final Key key = new SecretKeySpec("0123456789ABCDEF".getBytes(), "AES");
    private static final Cipher cipher = Cipher.getInstance("AES");

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                if (message.equals("exit")) {
                    break;
                }

                // Encrypt the message
                byte[] encryptedMessage = encryptMessage(message);
                out.println(new String(Base64.getEncoder().encode(encryptedMessage)));
            }

            clientSocket.close();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static byte[] encryptMessage(String message) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(message.getBytes());
    }
}