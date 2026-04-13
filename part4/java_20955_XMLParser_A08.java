import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_20955_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");  // your XML file path here

            // Create DocumentBuilderFactory and set its security manager
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);  // disable validation for security reasons
            factory.setNamespaceAware(true);  // enable namespace for security reasons
            factory.setXIncludeSchemaResolver(null);  // disable XInclude for security reasons
            factory.setXSchemaResolver(null);  // disable XSchema for security reasons
            factory.setAccessExternalResources(false);  // disable access to external resources for security reasons

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("*");
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println(nodes.item(i).getNodeName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}