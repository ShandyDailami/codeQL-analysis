import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.apache.xml.security.Init;
import org.apache.xml.security.utils.SecurityUtils;

public class java_33254_XMLParser_A08 {

    public static void main(String[] args) {

        try {
            // Load the XML Security library
            SecurityUtils.loadKeyStore("truststore.p12", "truststorepassword", "keystorepassword");
            
            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document doc = builder.parse(new File("example.xml"));

            // Print out the XML data
            doc.getDocumentElement().normalize();
            System.out.println(doc.getElements().get(0).getChildNodes().item(0).getNodeValue());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Unload the XML Security library
            SecurityUtils.unloadKeyStore();
        }
    }
}