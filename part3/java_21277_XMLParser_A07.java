import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21277_XMLParser_A07 {
    public static void main(String[] args) {
        // Creating a factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Creating a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsing the XML file
            Document doc = builder.parse("sample.xml");

            // Print out the document elements
            printElements(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        // Print out the name and value of each element
        doc.getElements().forEach(element -> {
            System.out.println("Element name: " + element.getNodeName());
            System.out.println("Element value: " + element.getTextContent());
        });
    }
}