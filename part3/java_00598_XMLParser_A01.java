import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class java_00598_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new Document object
            Document doc = builder.parse("sample.xml");

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print all the elements in the document
            printElements(root);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        // Print the element
        System.out.println("Element: " + element.getNodeName());

        // Print the attributes
        if (element.hasAttributes()) {
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                System.out.println("Attribute: " + element.getAttributes().item(i).getNodeName() + " = " + element.getAttributes().item(i).getTextContent());
            }
        }

        // Print the children
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            printElements((Element) element.getChildNodes().item(i));
        }
    }
}