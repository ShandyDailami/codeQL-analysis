import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34766_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Here we are just logging the document to the console
            // for demonstration purposes. You would replace this with
            // your own security-sensitive operations.
            System.out.println("Document: " + document.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}