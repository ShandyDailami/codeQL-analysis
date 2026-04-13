import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.security.KeyStore;

public class java_15192_SocketServer_A01 {

    private static final String KEYSTORE_LOCATION = "/path/to/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "keyAlias";

    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        InputStream inputStream = SecureSocketServer.class.getClassLoader().getResourceAsStream(KEYSTORE_LOCATION);
        keyStore.load(inputStream, KEYSTORE_PASSWORD.toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8001, null, keyStore, KEY_ALIAS.toCharArray(), new TrustManagerFactory().getDefaultTrustStorePassword().toCharArray());

        while (true) {
            SSLSocket client = (SSLSocket) sslServerSocket.accept();
            client.setNeedClientAuth(true);

            OutputStream outputStream = client.getOutputStream();
            InputStream inputStream = client.getInputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            if (bytesRead < 0) {
                break;
            }

            String response = "Hello, Client!";
            outputStream.write(response.getBytes());
            outputStream.flush();

            client.close();
        }

        sslServerSocket.close();
    }
}