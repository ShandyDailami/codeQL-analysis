import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class java_30433_SocketServer_A07 {

    private static final String KEYSTORE_LOCATION = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            // Load keys and truststore
            sslServerSocket.setUseClientMode(true);
            sslServerSocket.getSSLParameters().setKeyStore(KeyStore.getInstance("JKS"),
                    KEYSTORE_PASSWORD.toCharArray());
            sslServerSocket.getSSLParameters().setKeyStorePassword(KEYSTORE_PASSWORD);
            sslServerSocket.getSSLParameters().setTrustStore(KeyStore.getInstance("JKS"),
                    TRUSTSTORE_PASSWORD.toCharArray());
            sslServerSocket.getSSLParameters().setTrustStorePassword(TRUSTSTORE_PASSWORD);

            System.out.println("Waiting for client authentication ...");
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            System.out.println("Client authenticated successfully!");

            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            byte[] bytes = new byte[1024];
            int length;
            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }

            sslSocket.close();
        } catch (IOException | java.security.GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}