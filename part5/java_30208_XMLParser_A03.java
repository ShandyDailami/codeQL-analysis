import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_30208_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for the document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false); // Disable validation to avoid security issues

            // Get the document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document doc = builder.parse("input.xml"); // Replace "input.xml" with your XML file

            // Process the XML document
            // This is a very basic example, you should handle errors, exceptions, and use the Document object to manipulate the XML data
            // For instance, you can print the document's elements
            doc.getElementsByTagName("element").item(0).getTextContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}