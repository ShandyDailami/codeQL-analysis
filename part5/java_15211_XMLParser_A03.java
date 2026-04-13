import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_15211_XMLParser_A03 {
    public static void main(String[] args) {
        // Load the XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("sample.xml"));

        // Extract the names
        NodeList nodeList = doc.getElementsByTagName("name");

        // Process each name
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            String name = element.getTextContent();

            // Security-sensitive operation: We'll print the name.
            System.out.println("Processing name: " + name);

            // Syntactically correct code, security-sensitive operation.
            try {
                // Security-sensitive operation, not recommended.
                Class.forName("sun.misc.JavaSecurityManager");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Security-sensitive operation, not recommended.
            if (name.length() > 100) {
                System.out.println("Name is too long: " + name);
            }
        }

        // Security-sensitive operation, not recommended.
        System.out.println("End of processing.");
    }
}