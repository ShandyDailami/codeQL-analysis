import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_28092_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Load the key store
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(XmlParser.class.getResourceAsStream("/mykeystore.jks"), "password".toCharArray());

            // Get the key from the key store
            Certificate cert = ks.getCertificate("myAlias");

            // Create a document builder factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder and parse the XML from the document
            DocumentBuilder builder = factory.newDocumentBuilder(ks.getCertificateChain("myAlias"));
            Document document = builder.parse(XmlParser.class.getResourceAsStream("/myfile.xml"));

            // Print out the XML contents
            document.getDocumentElement().getFirstChild().getNodeValue());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}