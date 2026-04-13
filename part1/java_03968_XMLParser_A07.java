import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import org.xml.sax.SAXException;

public class java_03968_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all child nodes of the root element
            NodeList nodes = root.getChildNodes();

            // Process each child node
            for (int i = 0; i < nodes.getLength(); i++) {
                Element node = (Element) nodes.item(i);
                String nodeName = node.getNodeName();
                String nodeValue = node.getFirstChild().getNodeValue();
                System.out.println("Node Name: " + nodeName + ", Node Value: " + nodeValue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}