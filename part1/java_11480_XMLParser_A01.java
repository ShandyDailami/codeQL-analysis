import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class java_11480_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("input.xml"));

            // Get all the elements in the document
            NodeList nodeList = document.getElementsByTagName("*");

            // Iterate over each node
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Get the current node
                Element element = (Element) nodeList.item(i);

                // Get the name and value of the current node
                String nodeName = element.getNodeName();
                String nodeValue = element.getTextContent();

                // Print out the name and value
                System.out.println("Node Name: " + nodeName);
                System.out.println("Node Value: " + nodeValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}