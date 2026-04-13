import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_11702_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a factory object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all element names
            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    System.out.println("Element: " + node.getNodeName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}