import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_10960_SocketServer_A08 {

    private static final String SSL_PORT = "8080";
    private static final String KEYSTORE_PATH = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_password";
    private static final String TRUSTSTORE_PATH = "path_to_your_truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "your_password";

    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName("127.0.0.1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SSLServerSocketFactory sslServerSocketFactory = null;
        try {
            sslServerSocketFactory = getSSLServerSocketFactory(address,
                    SSL_PORT, KEYSTORE_PATH, KEYSTORE_PASSWORD, TRUSTSTORE_PATH, TRUSTSTORE_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            Socket socket = null;
            try {
                socket = sslServerSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (socket == null) {
                continue;
            }
            // Handle client
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory(InetAddress address, String port,
                                                                  String keystorePath, String keystorePassword,
                                                                  String truststorePath, String truststorePassword) {
        SSLServerSocketFactory sslServerSocketFactory = null;
        try {
            KeyManagerFactory keyManagerFactory = getKeyManagerFactory(keystorePath, keystorePassword);
            KeyStore trustStore = getKeyStore(truststorePath, truststorePassword);
            sslServerSocketFactory = new SSLServerSocketFactory(keyManagerFactory, trustStore);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslServerSocketFactory;
    }

    private static KeyManagerFactory getKeyManagerFactory(String keystorePath, String keystorePassword) {
        KeyManagerFactory keyManagerFactory = null;
        try {
            keyManagerFactory = KeyManagerFactory.getDefaultInstance(new KeyStoreKeyFactory(
                    new FileInputStream(keystorePath), keystorePassword.toCharArray()));
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keyManagerFactory;
    }

    private static KeyStore getKeyStore(String path, String password) {
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(new FileInputStream(path), password.toCharArray());
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keyStore;
    }
}