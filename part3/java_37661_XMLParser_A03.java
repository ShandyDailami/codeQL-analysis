import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_37661_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a new instance of DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to build a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the input XML file into a Document object
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element of the document
            Element root = doc.getDocumentElement();

            // Get all child elements of the root element
            NodeList children = root.getChildNodes();

            // Loop through all child nodes
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);

                // If the node is an element, print its tag name and text
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Tag: " + element.getTagName());
                    System.out.println("Text: " + element.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}