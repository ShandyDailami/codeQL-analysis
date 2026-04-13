import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_31944_XMLParser_A03 {

    public Document parse(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(fileName));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        Document doc = parser.parse("example.xml");
        // Continue with parsing logic if necessary
    }
}