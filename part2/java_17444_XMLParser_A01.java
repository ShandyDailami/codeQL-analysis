import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_17444_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Extract and print the values of the elements
            printElementValues(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementValues(Element element) {
        // Get the element's values
        String value = element.getFirstChild().getNodeValue();

        // Print the value
        System.out.println("Element: " + element.getNodeName() + ", Value: " + value);

        // Get the element's children
        List<Element> children = List.of(element.getChildNodes());

        // Recursively print the values of the children
        for (int i = 0; i < children.size(); i++) {
            printElementValues((Element) children.get(i));
        }
    }
}