import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_02640_XMLParser_A03 {
    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory and use it to create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 2: Use the DocumentBuilder to parse the XML file
        Document doc = null;
        try {
            doc = builder.parse(new File("sample.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        // Step 3: Access the XML elements and attributes, performing security-sensitive operations
        // Here, we're just printing the element and attribute names and values for demonstration purposes
        doc.getElementsByTagName("*").item(0).getNodeName();
        doc.getElementsByTagName("*").item(0).getAttributes().item(0).getNodeName();
    }
}