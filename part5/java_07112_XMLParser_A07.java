import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ElementHandler;
import org.xml.sax.XMLReader;

public class java_07112_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            DefaultHandler handler = new DefaultHandler();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            xmlReader.setContentHandler(handler);
            xmlReader.parse("path_to_your_xml_file.xml");

            System.out.println("Parsing was successful!");
        } catch (SAXException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}