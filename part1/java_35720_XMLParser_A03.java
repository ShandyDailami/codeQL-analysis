import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35720_XMLParser_A03 {
    public static void main(String[] args) {
        // Step 1: Create a factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Step 2: Create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse("input.xml");

            // Step 4: Process the document
            // Here, we're just printing out the names of all the elements in the document
            doc.getElementsByTagName("*").item(0).getNodeName();

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}