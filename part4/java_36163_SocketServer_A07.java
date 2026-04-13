import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_36163_SocketServer_A07 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;

        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) keyStore.getKeyFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(443);

            // Enable client authentication
            sslServerSocket.setNeedClientAuth(true);

            SSLSocket client = (SSLSocket) sslServerSocket.accept();
            client.startHandshake();

            // Perform authentication here
            if (client.getRemoteSocket().getState() == Socket.BOTH_SYN_SENT) {
                // Continue handshake if client authentication succeeds
                System.out.println("Client successfully authenticated");
                OutputStream out = client.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello client, you are successfully authenticated!");
            } else {
                System.out.println("Client failed to authenticate");
            }

            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}