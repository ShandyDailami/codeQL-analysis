import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_07615_SocketServer_A08 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_PASSWORD = "password";
    private static final String ALIAS = "alias";

    public static void main(String[] args) throws Exception {
        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(new java.security.cert.InputStreamReader(
                SocketServer.class.getResourceAsStream("/keystore.jks")), KEYSTORE_PASSWORD.toCharArray());

        Certificate certificate = keystore.getCertificate(ALIAS);
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8090, null, certificate);

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setUseClientMode(true);

            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            // Send a message to the client
            String message = "Hello, client!";
            outputStream.write(message.getBytes());
            outputStream.close();

            // Receive a response from the client
            byte[] bytes = new byte[256];
            int readBytes = inputStream.read(bytes);
            String response = new String(bytes, 0, readBytes);
            System.out.println("Server received: " + response);

            sslSocket.close();
        }
    }
}