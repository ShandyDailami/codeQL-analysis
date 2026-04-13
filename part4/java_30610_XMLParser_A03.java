import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_30610_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print out the content of the root element
            System.out.println("Root element: " + root.getNodeName());

            // Get all child nodes of the root element
            NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) child;
                    System.out.println("Child element: " + element.getNodeName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}