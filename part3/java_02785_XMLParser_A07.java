import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_02785_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document doc = builder.parse(new File("example.xml"));

            // Get all the elements in the document
            NodeList nodeList = doc.getElementsByTagName("*");

            // Loop through all the elements
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Get the current element
                Node node = nodeList.item(i);

                // Print the name and value of the element
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getNodeName());
                    System.out.println("Value: " + element.getFirstChild().getNodeValue());
                }
           
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}