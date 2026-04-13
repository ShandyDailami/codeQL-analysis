import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_11937_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a builder for handling our XML document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML file
            Document doc = builder.parse("sample.xml");

            // Here we can use the XML document object for our security-sensitive operations
            // For example, we can check if the document is broken or not
            if (doc.getDoctype() != null) {
                System.out.println("Document is a valid DTD");
            } else {
                System.out.println("Document is not a valid DTD");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}