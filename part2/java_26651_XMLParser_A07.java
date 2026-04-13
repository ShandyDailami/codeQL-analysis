import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_26651_XMLParser_A07 {

    public static void main(String[] args) throws Exception {
        // Load the keystore
        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(XMLParser.class.getResourceAsStream("/keystore.jks"), "password".toCharArray());

        // Create a document builder factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidate(true);
        factory.setNamespaceAware(true);

        // Set the Keystore and type
        DocumentBuilder builder = factory.newDocumentBuilder(new javax.xml.transform.dom.DOMSource(
                new Document()));
        builder.setEntityResolver(new XMLSecureEntityResolver(keystore));

        // Parse the XML
        Document document = builder.parse(XMLParser.class.getResourceAsStream("/data.xml"));

        // Extract the data
        NodeList nodeList = document.getElementsByTagName("data");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getTextContent());
        }
    }
}