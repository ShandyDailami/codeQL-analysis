import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_02742_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the XML file
            Document document = builder.parse(new File("sample.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Print all element names
            printElementNames(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Element element) {
        System.out.println("Element: " + element.getNodeName());
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) child;
                System.out.println("  -> " + e.getNodeName());
            }
        }
    }
}