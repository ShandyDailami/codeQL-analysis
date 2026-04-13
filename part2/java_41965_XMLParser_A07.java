import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_41965_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Step 2: Get all the element nodes
            NodeList nodeList = doc.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Step 3: Get all the attributes of the element
                    NodeList attributes = element.getAttributes();
                    for (int j = 0; j < attributes.getLength(); j++) {
                        Node attribute = attributes.item(j);
                        System.out.println("Attribute: " + attribute.getNodeName() + " = " + attribute.getTextContent());
                    }

                    // Step 4: Get all the child nodes of the element
                    NodeList childNodes = element.getChildNodes();
                    for (int k = 0; k < childNodes.getLength(); k++) {
                        Node childNode = childNodes.item(k);
                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element childElement = (Element) childNode;
                            System.out.println("Child element: " + childElement.getTagName());
                        } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                            System.out.println("Child text: " + childNode.getTextContent());
                        }
                    }

                    System.out.println("------------------------");
                }
            }

            // The parser has completed successfully
            System.out.println("XML Parser has completed successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}