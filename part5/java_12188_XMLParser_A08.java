import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_12188_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document document = builder.parse(new File("path_to_your_file.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Get all child nodes
            NodeList nodes = root.getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                // Check if the node is an element
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Cast the node to an Element
                    Element element = (Element) node;

                    // Access the attributes
                    String attributeValue = element.getAttribute("attribute_name");

                    // Access the child nodes
                    NodeList childNodes = element.getChildNodes();

                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);

                        // Check if the child node is an element
                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                            // Cast the child node to an Element
                            Element childElement = (Element) childNode;

                            // Access the attributes
                            String childAttributeValue = childElement.getAttribute("attribute_name");

                            // Access the child nodes
                            NodeList childChildNodes = childElement.getChildNodes();

                            for (int k = 0; k < childChildNodes.getLength(); k++) {
                                Node childChildNode = childChildNodes.item(k);

                                // Check if the child child node is an element
                                if (childChildNode.getNodeType() == Node.ELEMENT_NODE) {
                                    // Cast the child child node to an Element
                                    Element childChildElement = (Element) childChildNode;

                                    // Access the attributes
                                    String childChildAttributeValue = childChildElement.getAttribute("attribute_name");

                                    // Access the text within the child child nodes
                                    String childChildNodeText = childChildElement.getTextContent();

                                    // Print the results
                                    System.out.println("Attribute: " + childChildElement.getAttribute("attribute_name"));
                                    System.out.println("Child Child Node Text: " + childChildNodeText);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}