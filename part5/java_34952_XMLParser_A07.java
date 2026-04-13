import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_34952_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and use it to create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to read and load the XML file
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // Print all the nodes and elements in the document
            printNodesAndElements(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodesAndElements(Document doc) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getTagName());
                printAttributes(element);
            }
        }
    }

    private static void printAttributes(Element element) {
        System.out.println("Attributes:");
        for (int i = 0; i < element.getAttributes().getLength(); i++) {
            System.out.println(element.getAttributes().item(i).getNodeName() + "=" + element.getAttributes().item(i).getTextContent());
        }
    }
}