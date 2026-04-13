import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_24806_XMLParser_A01 {

    public boolean isSecure(String xmlDocument) {
        // Create a new DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a new DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML document and store in the Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlDocument)));

            // Check if the document is empty
            if (doc.getElements().getLength() == 0) {
                return false; // The document is empty, so it's not secure
            }

            // The document is not empty, so it's secure
            return true;
        } catch (IOException | SAXException e) {
            e.printStackTrace();
            return false; // An error occurred while parsing the document
        }
    }
}