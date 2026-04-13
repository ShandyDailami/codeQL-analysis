import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_07970_XMLParser_A01 {
    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory and a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 2: Use the DocumentBuilder to parse the XML document
        Document doc = null;
        try {
            doc = builder.parse(new File("broken-access-control.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        // Step 3: Print the XML document content
        System.out.println(doc.getDocumentElement().getNodeName());
    }
}