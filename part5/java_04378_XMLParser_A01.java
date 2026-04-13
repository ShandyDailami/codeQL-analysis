import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_04378_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for the parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new document
            Document doc = builder.parse(new File("src/main/resources/sample.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // List all the child nodes
            listAllChildren(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listAllChildren(Element element) {
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) child;
                System.out.println("Element: " + elem.getNodeName());
                listAllChildren(elem);
            }
        }
    }
}