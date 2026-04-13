import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_09962_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and use it to create a Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("sample.xml")); // Change this to your XML file

            // Print the XML document node and its elements
            printNodes(doc, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(Node node, String indent) {
        if (node != null) {
            if (indent != null) {
                System.out.print(indent);
            }

            // Print node name and attributes if any
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.print(element.getNodeName());
                if (element.hasAttributes()) {
                    for (int i = 0; i < element.getAttributes().getLength(); i++) {
                        System.out.print(" " + element.getAttributes().item(i).getNodeName() + "=" + element.getAttributes().item(i).getTextContent());
                    }
                }
                System.out.println();
            }

            // If node is a text node then print its text
            if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.print(((Text) node).getNodeValue());
            }

            // Print nodes recursively for children
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                printNodes(children.item(i), indent + "  ");
            }
        }
    }
}