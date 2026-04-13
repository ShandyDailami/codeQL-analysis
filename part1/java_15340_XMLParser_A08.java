import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_15340_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("resources/sample.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);

            // Parsing and handling the document here.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}