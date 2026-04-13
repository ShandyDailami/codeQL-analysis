import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_22086_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file.xml"; // replace with your xml file path
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(new File(xmlFile));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Get the root element
        Element rootElement = document.getDocumentElement();
        System.out.println("Root element: " + rootElement.getNodeName());

        // Traverse the XML tree
        traverse(rootElement);
    }

    private static void traverse(Node node) {
        if (node == null) {
            return;
        }

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.println("Element: " + element.getNodeName());
            System.out.println("Attributes: ");
            NodeList attributes = element.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attribute = attributes.getItem(i);
                System.out.println(attribute.getNodeName() + " = " + attribute.getTextContent());
            }

            // Traverse child nodes
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                traverse(childNodes.getItem(i));
            }
        }
    }
}