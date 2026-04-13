import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_41183_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // replace with your xml file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Get the root element
            Element rootElement = document.getDocumentElement();

            System.out.println("Root element: " + rootElement.getNodeName());

            // Get all the child elements
            NodeList childElements = rootElement.getChildNodes();
            for (int i = 0; i < childElements.getLength(); i++) {
                Node childNode = childElements.item(i);
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) childNode;
                    System.out.println("Child element: " + childElement.getNodeName());
                    System.out.println("Child element attributes: " + childElement.getAttributes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}