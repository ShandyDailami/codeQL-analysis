import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_30097_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the input XML file and create a Document object
            Document doc = builder.parse(new File("input.xml"));

            // Step 4: Process the document here, e.g., print all element names
            doc.getElementsByTagName("*").item(0).getNodeName();

            // Step 5: Handle the Document object
            // ...

            // Step 6: Handle exceptions
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}