import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.security.KeyStore.SecretKey;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import java.security.KeyManagementException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class java_20681_XMLParser_A07 {
    public static void main(String[] args) throws Exception {
        try {
            // Create a new SSLContext that uses a TrustManagerFactory to check
            // if the client certificate used to connect is in the list of
            // trusted certificates.
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(new KeyStore[]{createKeyStore("src/main/resources/truststore.jks", "truststorepassword".toCharArray())});
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), new java.security.SecureRandom());

            // Create a new SSLServerSocketFactory that uses the configured SSLContext
            SSLServerSocketFactory sslServerSocketFactory = new SSLServerSocketFactory(sslContext);
            SSLServerSocket serverSocket = (SSLServerSocket)sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            // Accept a new SSLSocket and handle it.
            SSLSocket clientSocket = (SSLSocket)serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static KeyStore createKeyStore(String keyStoreFile, char[] keyStorePassword) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream(keyStoreFile), keyStorePassword);
        return keyStore;
    }
}