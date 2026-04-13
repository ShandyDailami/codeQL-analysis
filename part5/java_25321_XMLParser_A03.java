import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_25321_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML file
            Document document = builder.parse("input.xml");

            // Process the XML document here, for example, print out the names of all elements
            printElementNames(document);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Document document) {
        // Print out the names of all elements
        document.getElementsByTagName("*").forEach(node -> {
            System.out.println("Element: " + node.getNodeName());
        });
    }
}