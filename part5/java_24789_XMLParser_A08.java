import java.security.Security;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_24789_XMLParser_A08 {

    private DefaultHandler handler;
    private SAXParser saxParser;

    public java_24789_XMLParser_A08() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParser = saxParserFactory.newSAXParser(true);
        handler = new DefaultHandler();
    }

    public void parse(String xml) {
        try {
            saxParser.parse(xml, handler);
        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}