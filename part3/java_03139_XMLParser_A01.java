import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_03139_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("example.xml");

            // You can start your security-sensitive operations here.

            // For instance, we'll just print out the parsed XML data.
            document.getDocumentElement().normalize();
            System.out.println("Root Element: " + document.getElements().getNamedItem("root"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}