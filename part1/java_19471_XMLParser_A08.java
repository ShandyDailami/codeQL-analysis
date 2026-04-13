import java.io.File;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_19471_XMLParser_A08 {

    public static void main(String[] args) {
        // Load the KeyStore
        KeyStore ks = KeyStore.getInstance("JKS");
        try {
            ks.load(new File("keystore.jks"), "password".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | java.io.IOException e) {
            e.printStackTrace();
        }

        // Setup DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setValidating(true);
        dbFactory.setNamespaceAware(true);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // Parse the XML file
        Document doc = dBuilder.parse(new File("sample.xml"));
        doc.getDocumentElement().normalize();

        // Print out the parsed XML
        System.out.println("XML Parsed Successfully!");
    }
}