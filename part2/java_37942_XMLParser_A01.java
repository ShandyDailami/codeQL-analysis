import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_37942_XMLParser_A01 {

    public static void main(String[] args) {

        // Create a factory for the DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Use the factory to create a new Document
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("sample.xml"));

        // Get the root element
        Element root = doc.getDocumentElement();

        // Get all the children elements of the root
        NodeList children = root.getChildNodes();

        // Process each child node
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getTagName());
                System.out.println("Attribute: " + element.getAttribute("attribute"));
                System.out.println("Value: " + element.getTextContent());
            }
        }
    }
}