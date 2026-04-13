import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_38463_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Here you can use the parsed XML document, for example, for security sensitive operations.

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}