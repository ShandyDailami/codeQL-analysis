import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;

public class java_20808_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "brokenAccessControl.xml";

        DefaultHandler handler = new DefaultHandler();
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}