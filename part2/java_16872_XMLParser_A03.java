import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_16872_XMLParser_A03 {
    public static void main(String[] args) {
        // File path
        String filePath = "/path/to/your/file.xml";

        try {
            // Create DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse XML file
            Document doc = builder.parse(new File(filePath));

            // Print the document nodes and attributes
            printDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printDocument(Document doc) {
        // Print all the nodes
        System.out.println(doc.getDocumentElement().getNodeName());
    }
}