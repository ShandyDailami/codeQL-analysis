import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_19618_XMLParser_A08 {
    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Step 2: Get a DocumentBuilder from the factory
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 3: Parse the XML document
        Document doc = builder.parse(new File("input.xml"));

        // Step 4: Process the document (e.g., print all element names)
        doc.getElementsByTagName("*").item(0).getNodeName();
    }
}