import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_18787_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and use it to create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = builder.parse(new File("input.xml"));

            // Print all the elements in the document
            printElements(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
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
        System.out.println("Attributes: ");
        for (int i = 0; i < element.getAttributes().getLength(); i++) {
            System.out.println("Attribute: " + element.getAttributes().item(i).getNodeName() + "=" + element.getAttributes().item(i).getNodeValue());
        }
    }
}