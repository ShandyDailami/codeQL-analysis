import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_05987_SocketServer_A08 {
    private static final String KEYSTORE_PATH = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "keystore_password";
    private static final String KEY_PASSWORD = "key_password";
    private static final String ALIAS = "alias";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());

            KeyStore keystore = keyStore;
            Key key = keystore.getKey(ALIAS, KEY_PASSWORD.toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter your message: ");
            String message = reader.readLine();
            outputStream.write(message.getBytes());
            outputStream.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}