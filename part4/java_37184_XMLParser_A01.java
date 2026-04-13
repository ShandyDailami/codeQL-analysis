import java.io.File;
import java.io.IOException;
import java.security.Policy;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_37184_XMLParser_A01 {
    public static void main(String[] args) {
        // Create a factory for the DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setAccessingExternalEntities(true);

        DocumentBuilder builder = factory.newDocumentBuilder();

        // Use a security policy to prevent access to untrusted resources
        builder.setEntityResolver(new Policy());

        // Parse the XML file
        Document doc = null;
        try {
            doc = builder.parse(new File("example.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO: Perform some operations with the parsed document
    }
}