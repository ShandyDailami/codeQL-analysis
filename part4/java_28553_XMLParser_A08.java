import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_28553_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for the document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for the document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the document
            Document document = builder.parse(new File("sample.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Get all the child elements of the root
            NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                // Print information of each child element
                if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element child = (Element) children.item(i);
                    System.out.println("Element: " + child.getNodeName());
                    System.out.println("Value: " + child.getFirstChild().getNodeValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}