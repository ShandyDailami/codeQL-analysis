import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.xml.sax.SAXParseException;

public class java_28219_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a new instance of the XML parser
            javax.xml.parsers.XMLParser parser = javax.xml.parsers.XMLParser.getNewInstance();

            // Parse the XML document
            Document doc = parser.parse("example.xml");

            // Print out the document
            System.out.println(doc.getDocumentElement().getNodeName());
        } catch (SAXParseException e) {
            System.out.println("SAXParseException: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        }
    }
}