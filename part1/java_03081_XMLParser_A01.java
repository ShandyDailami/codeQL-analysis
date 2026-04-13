import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_03081_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the KeyStore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Main.class.getResourceAsStream("/keyStore.jks"), "password".toCharArray());

            // Get the KeyStore and its password
            KeyStore keyStore2 = (KeyStore) keyStore.getDefaultKeyStore();
            char[] password = "password".toCharArray();

            // Check the access to the KeyStore
            boolean access = keyStore.isKeyEntry(null, password);
            System.out.println("Access to KeyStore: " + access);

            // Create an XML Parser
            javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();

            // Try to parse an XML
            org.w3c.dom.Document doc = db.parse(Main.class.getResourceAsStream("/sample.xml"));

            // If parse is successful, print the document
            System.out.println(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}