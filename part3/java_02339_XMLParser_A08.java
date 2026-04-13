import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import org.xml.sax.sax2.SAX2XMLReader;

public class java_02339_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            DefaultHandler handler = new DefaultHandler();

            reader.setContentHandler(handler);
            reader.parse(xmlFile);

            System.out.println("XML Parsed Successfully");
        } catch (SAXException e) {
            System.out.println("Failed to parse XML: " + e.getMessage());
       
        }
    }
}