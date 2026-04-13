import java.io.IOException;
import java.net.InetSocketAddress;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_32769_SocketServer_A07 {

    private static final String KEY = "AES_KEY"; // Replace with your own key
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(4444, null, null, null);
            SSLSocket socket;
            while (true) {
                socket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");
                // Authenticate the client
                String clientCert = socket.getRemoteSocketAddress().toString();
                String password = clientCert.split(":")[1];
                SecretKeySpec key = new SecretKeySpec(password.getBytes(), ALGORITHM);
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.DECRYPT_MODE, key);
                byte[] decryptedMessage = cipher.doFinal(socket.getInputStream().readBytes());
                String message = new String(decryptedMessage);
                System.out.println("Message from client: " + message);
                if ("exit".equals(message)) {
                    break;
                }
                socket.getOutputStream().write("Thank you for connecting".getBytes());
                socket.getOutputStream().flush();
             }
        } finally {
            serverSocket.close();
        }
    }
}