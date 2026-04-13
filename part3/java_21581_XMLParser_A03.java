import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_21581_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Use the builder to parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Step 4: Use the document object to access the parsed data
            NodeList nodes = doc.getElementsByTagName("element");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Text in node " + (i + 1) + ": " + node.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}