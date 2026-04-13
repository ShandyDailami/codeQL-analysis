import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_01205_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document document = builder.parse("sample.xml");

            // Your security-sensitive operations go here
            // For example, here we just print out the document name and namespace
            System.out.println("Document Name: " + document.getDocumentElement().getNodeName());
            System.out.println("Document Namespace: " + document.getDocumentElement().getNamespaceURI());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}