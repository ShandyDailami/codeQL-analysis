import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_03243_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the document
            Document doc = builder.parse("input.xml");

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print out the element names
            printElements(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        System.out.println(element.getTagName());
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            printElements((Element) element.getChildNodes().item(i));
        }
    }
}