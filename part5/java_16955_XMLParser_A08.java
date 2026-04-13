import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_16955_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse("input.xml");  // replace with your file name

            // parse the xml document
            System.out.println("XML Parsed Successfully");
        } catch (Exception e) {
            System.out.println("Error in parsing XML: " + e);
        }
    }
}