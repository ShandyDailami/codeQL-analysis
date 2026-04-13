import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_41229_XMLParser_A01 {
    public static void main(String[] args) {
        // Create a factory for the parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a builder for the XML document
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file
        Document doc = builder.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"));

        // TODO: Add security-sensitive operations related to A01_BrokenAccessControl
        // For example, check if the document is empty
        if (doc.getDocumentElement().getNodeName().equals("")) {
            System.out.println("Document is empty.");
        }
    }
}