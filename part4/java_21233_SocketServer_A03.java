import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_21233_SocketServer_A03 {

    private static final String KEYSTORE_PATH = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_PATH = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";
    private static final String KEY_ALIAS = "your_key_alias";

    public static void main(String[] args) throws Exception {

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SocketServer.class.getResourceAsStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());
        Key key = keyStore.getKey(KEY_ALIAS, KEYSTORE_PASSWORD.toCharArray());

        Certificate certificate = (Certificate) keyStore.getCertificate(KEY_ALIAS);

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(SocketServer.class.getResourceAsStream(TRUSTSTORE_PATH), TRUSTSTORE_PASSWORD.toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(new KeyStoreTrustStore(trustStore));

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword(KEYSTORE_PASSWORD);
        sslServerSocketFactory.setTrustStore(trustStore);
        sslServerSocketFactory.setTrustStorePassword(TRUSTSTORE_PASSWORD);

        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setUseClientMode(true);

            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            Cipher cipher = Cipher.getInstance("TLS");
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                byte[] decrypted = cipher.update(buffer, 0, bytesRead);
                output.write(decrypted);
            }

            byte[] finished = cipher.doFinal();
            output.write(finished);

            clientSocket.close();
        }
    }
}