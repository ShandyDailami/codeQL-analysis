import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27465_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true); // Enable validation

            // Create a new builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML
            Document doc = builder.parse("input.xml");

            // Here you can use your code to work with the XML document.
            // For example, print the document's root element:
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}