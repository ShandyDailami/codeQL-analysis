import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_06194_XMLParser_A03 {

    public static void main(String[] args) {
        // Create a DocumentBuilderFactory and use it to create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Use the builder to parse the XML file and store the result in a Document object
        Document document = null;
        try {
            document = builder.parse(new File("sample.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        // Here, you can perform security-sensitive operations related to A03_Injection
        // For example, you can print the XML content
        System.out.println(document.getDocumentElement().getNodeName());
    }
}