import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_29895_XMLParser_A01 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("sample.xml"));
            // Here is where you can perform security-sensitive operations
            // e.g., reading the XML file and printing the document
            System.out.println(doc.getDocumentElement().getNodeName());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}