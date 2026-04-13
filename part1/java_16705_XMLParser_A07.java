import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_16705_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new document
            Document doc = builder.newDocument();

            // Load the XML document
            doc.load("src/main/resources/authfailure.xml"); // Change the file path to your XML file

            // Process the document (e.g., print the document title)
            System.out.println("Document title: " + doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}