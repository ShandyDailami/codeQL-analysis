import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class java_15522_SocketServer_A08 {
    private static final String KEYSTORE_PATH = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "keystore_password";
    private static final String TRUSTSTORE_PATH = "path_to_your_truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "truststore_password";
    private static final String ALIAS = "ssl_server";

    public static void main(String[] args) throws Exception {
        runServer(8080);
    }

    private static void runServer(int port) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
        sslServerSocket.setNeedClientAuthentication(true);
        sslServerSocket.setDegraded(true);

        while (true) {
            Socket clientSocket = sslServerSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            SSLContext sslContext = getSSLContext(KEYSTORE_PATH, KEYSTORE_PASSWORD, TRUSTSTORE_PATH, TRUSTSTORE_PASSWORD);
            sslContext.init(null, new String[]{ALIAS}, null);

            dataOutputStream.writeUTF("Hello from server!");
            dataOutputStream.flush();

            byte[] buffer = new byte[1024];
            dataInputStream.readFully(buffer);
            String message = new String(buffer, "UTF-8");
            System.out.println("Client says: " + message);

            clientSocket.close();
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory() {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            return sslServerSocketFactory;
        } catch (CertificateException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static SSLContext getSSLContext(String keystorePath, String keystorePassword, String truststorePath, String truststorePassword) {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream(keystorePath), keystorePassword.toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(new java.security.KeyStoreStores.PasswordPKCS12Store(keyStore, keystorePassword.toCharArray()));

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, trustManagerFactory.getTrustManagers(), null);
            return sslContext;
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | UnsupportedEncodingException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}