import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.SAXHelper;
import org.xml.sax.SAXParseException;

public class java_03780_XMLParser_A08 {

    public static void parseXML(String filename) {
        SAXHelper sax = new SAXHelper();
        XMLReader reader = sax.getXMLReader();

        reader.setContentHandler(new DefaultHandler() {
            public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
                // TODO: Implement security-sensitive operations here
            }
        });

        try {
            reader.parse(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            System.out.println("Parsing error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseXML("example.xml");
    }
}