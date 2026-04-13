import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;
import org.xml.sax.entries.SAXEntry;

public class java_11459_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // replace with your xml file
        DefaultHandler handler = new DefaultHandler();
        SAXReader reader = new SAXReader();
        try {
            SAXEntry entry = reader.build(xmlFile, handler);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(entry.getDocument());
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}