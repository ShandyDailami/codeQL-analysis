import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_08142_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file
            Document document = builder.parse(new File("input.xml"));

            // Get all the elements in the document
            NodeList nodeList = document.getElementsByTagName("*");

            // Iterate over all elements
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getNodeName());
                    System.out.println("Attributes: ");
                    for (int j = 0; j < element.getAttributes().getLength(); j++) {
                        System.out.println("Attribute: " + element.getAttributes().item(j).getNodeName() + " = " + element.getAttributes().item(j).getTextContent());
                    }
                    System.out.println("Children: ");
                    NodeList children = element.getChildNodes();
                    for (int k = 0; k < children.getLength(); k++) {
                        Node child = children.item(k);
                        if (child.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println("Child: " + ((Element) child).getNodeName());
                        } else if (child.getNodeType() == Node.TEXT_NODE) {
                            System.out.println("Text: " + child.getTextContent());
                        }
                    }
                    System.out.println("-----");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}