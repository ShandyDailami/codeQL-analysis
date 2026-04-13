import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_14887_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";

        // Step 1: Create a DocumentBuilderFactory and use it to create a Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File(xmlFile));
        } catch (SAXException e) {
            e.printStackTrace();
        }

        // Step 2: Perform security-sensitive operations related to A03_Injection
        // Here we just print the XML content for demonstration purposes.
        System.out.println(doc.getDocumentElement().getNodeName());
        System.out.println(doc.getElementsByTagName("tag").item(0).getTextContent());

        // Step 3: Use standard libraries only (no external frameworks)
        // Here we just print the XML content for demonstration purposes.
        System.out.println(doc.getDocumentElement().getNodeName());
        System.out.println(doc.getElementsByTagName("tag").item(0).getTextContent());
    }
}