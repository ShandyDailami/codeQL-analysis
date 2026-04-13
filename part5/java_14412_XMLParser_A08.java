import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_14412_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory instance
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder to parse XML document
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML document
            Document doc = dBuilder.parse("input.xml");

            // Print the parsed XML document
            System.out.println("XML Parsed Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}