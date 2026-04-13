import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_13887_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Get a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Get a DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the elements
            NodeList nodes = doc.getElementsByTagName("*");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                // Print the tag name
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getTagName());
                }
            }

            // Close the DocumentBuilder
            builder.getClass().cast(doc).close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}