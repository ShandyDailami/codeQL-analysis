import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_13747_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new Document
            Document doc = builder.parse(new File("example.xml"));

            // Get the root element
            NodeList nl = doc.getElementsByTagName("*");

            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i);

                // Print node name and content
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) n;
                    System.out.println("Element: " + e.getNodeName());
                    System.out.println("Content: " + e.getFirstChild().getNodeValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}