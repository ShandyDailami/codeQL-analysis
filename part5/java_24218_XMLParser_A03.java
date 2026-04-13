import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.StringReader;

public class java_24218_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<root><name>John Doe</name><email>john@example.com</email></root>";
        parseXml(xml);
    }

    public static void parseXml(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new InputSource(new StringReader(xml)));

            // Security-sensitive operations related to A03_Injection
            System.out.println("Name: " + doc.getElementsByTagName("name").item(0).getTextContent());
            System.out.println("Email: " + doc.getElementsByTagName("email").item(0).getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}