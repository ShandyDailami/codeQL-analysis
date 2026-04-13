import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_40895_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print the root element and its attributes
            System.out.println("Root element: " + root.getNodeName());

            // Get all child elements of the root element
            NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child instanceof Element) {
                    Element element = (Element) child;
                    System.out.println("Child element: " + element.getNodeName());
                    System.out.println("Child element attributes: " + element.getAttributes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}