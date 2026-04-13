import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_34525_XMLParser_A03 {
    public static void main(String[] args) {
        // Load the XML document
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("example.xml");

            // Get the list of nodes
            NodeList nodeList = document.getElementsByTagName("node");

            // Iterate over the list of nodes
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Node " + (i + 1) + ": " + node.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}