import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26101_SocketServer_A01 {
    private static final String KEYSTORE_PATH = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_password";
    private static final String TRUSTSTORE_PATH = "/path/to/your/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "your_password";

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            serverSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(ResourceLoader.getResourceAsStream(KEYSTORE_PATH),
                    KEYSTORE_PASSWORD.toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(ResourceLoader.getResourceAsStream(TRUSTSTORE_PATH),
                    TRUSTSTORE_PASSWORD.toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, trustStore, null);

            serverSocket.setSSLContext(sslContext);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.getChannel().accept();
                InputStream inputStream = sslSocket.getInputStream();

                // ... process the inputStream

                sslSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}