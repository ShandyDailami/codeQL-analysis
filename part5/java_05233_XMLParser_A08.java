import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_05233_XMLParser_A08 {
    public static void main(String[] args) {
        String keystorePath = "path/to/your/keystore.jks";
        String keystorePassword = "yourKeystorePassword";
        String keyPassword = "yourKeyPassword";

        try {
            loadKeyStore(keystorePath, keystorePassword, keyPassword);
        } catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void loadKeyStore(String keystorePath, String keystorePassword, String keyPassword)
            throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(keystorePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(inputStream, keystorePassword.toCharArray());

        keyStore.getKey(keyPassword, null).getClass().getName();
    }
}