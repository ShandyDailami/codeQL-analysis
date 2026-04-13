import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_39987_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a document builder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file into a Document object
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));
            // Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("*");
            for (int i = 0; i < nodes.getLength(); i++) {
                // Get the current node
                Node node = nodes.item(i);
                // If the node is an element
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Get the element
                    Element element = (Element) node;
                    // Get the element name
                    String elementName = element.getNodeName();
                    // Get the element attributes
                    String attributes = element.getAttributes().getLength() > 0 ? "Attributes: " : "";
                    for (int j = 0; j < element.getAttributes().getLength(); j++) {
                        attributes += element.getAttributes().item(j).getNodeName() + "=" + element.getAttributes().item(j).getTextContent() + " ";
                    }
                    // Print the element name and attributes
                    System.out.println(elementName + ": " + attributes);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}