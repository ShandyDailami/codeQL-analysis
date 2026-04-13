import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_08059_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Get a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Step 3: Extract the data from the document
            NodeList nodes = doc.getElementsByTagName("item");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Item " + (i + 1) + ": " + node.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}