import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_42098_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Load the keystore
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("keystore.jks"), "password".toCharArray());

            // Create a SecurityManager
            XMLSecurityManager securityManager = new XMLSecurityManager(ks, "OWSLParserHandler");

            // Set the SecurityManager
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidate(true);
            dbf.setNamespaceAware(true);
            dbf.setDefaultPermittedClause(new DeclarativeClause(new W3CMode(W3CNamespaceConcatenation.NONE), null));
            DocumentBuilder db = dbf.newDocumentBuilder();
            db.setEntityResolver(new MyEntityResolver());
            db.setSecurityManager(securityManager);

            // Parse the XML
            Document doc = db.parse("http://example.com/sample.xml");

            // Print the parsed XML
            doc.getDocumentElement().normalize();
            printDocument(doc);

        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(doc.getLineNumber(nodes.item(i)) + ": " + nodes.item(i).getTextContent());
        }
    }

    private static class MyEntityResolver extends EntityResolver {
        public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
            // Resolve the systemId to an InputSource
            return new InputSource(new StringReader(systemId));
        }
    }
}