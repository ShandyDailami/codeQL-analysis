import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_18421_SocketServer_A07 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_ALIAS = "your_key_alias";

    public static void main(String[] args) throws Exception {
        // Create a keystore using the keystore file and password
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream inputStream = SocketServer.class.getClassLoader().getResourceAsStream(KEYSTORE_LOCATION)) {
            keyStore.load(inputStream, KEYSTORE_PASSWORD.toCharArray());
        }

        // Get the Certificate from the keystore
        Certificate certificate = keyStore.getCertificate(KEY_ALIAS);

        // Create a truststore that contains the public key of the server
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(null, null);
        trustStore.setCertificateEntry(KEY_ALIAS, certificate);

        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(9999, keyStore, trustStore, KeyStore.getDefaultType(), new SSLServerSocket(9999));

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);

            // Start a new thread for handling the client
            new ClientHandler(sslSocket).start();
        }
    }

    static class ClientHandler extends Thread {
        private final SSLSocket sslSocket;

        public java_18421_SocketServer_A07(SSLSocket sslSocket) {
            this.sslSocket = sslSocket;
        }

        @Override
        public void run() {
            try (InputStream inputStream = sslSocket.getInputStream(); OutputStream outputStream = sslSocket.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}