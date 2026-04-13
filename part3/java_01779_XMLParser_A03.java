import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_01779_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to obtain a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML from the file
            Document doc = builder.parse("example.xml");

            // Normalize the document
            doc.normalize();

            // Print out element and attribute values
            printElementAndAttributes(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementAndAttributes(Document doc) {
        // Get all the elements in the document
        Element rootElement = doc.getDocumentElement();
        printElement(rootElement);
    }

    private static void printElement(Element element) {
        System.out.println("Element: " + element.getNodeName());

        // Print out attributes and their values
        for (int i = 0; i < element.getAttributes().getLength(); i++) {
            System.out.println("Attribute: " + element.getAttributes().item(i).getNodeName() + "=" + element.getAttributes().item(i).getTextContent());
        }

        // Recursive call for child elements
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            printElement((Element) element.getChildNodes().item(i));
        }
    }
}