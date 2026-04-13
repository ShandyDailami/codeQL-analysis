import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_33772_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            // Here you can use your parser's methods, such as to get the elements, attributes, etc.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}