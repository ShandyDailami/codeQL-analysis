import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_01173_XMLParser_A03 {
    public static void main(String[] args) {
        String url = "http://example.com/test.xml"; // replace with your XML file URL

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(url);

            System.out.println("XML Parsed successfully");
        } catch (Exception e) {
            System.out.println("Failed to parse XML due to " + e.getMessage());
        }
    }
}