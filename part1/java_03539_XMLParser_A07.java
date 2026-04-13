import java.net.URL;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_03539_XMLParser_A07 extends DefaultHandler {

    private String lastElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // do something with the parsed data here
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // do something with the parsed data here
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/sample.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MyXMLHandler handler = new MyXMLHandler();
            parser.parse(url.openStream(), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}