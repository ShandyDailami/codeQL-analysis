import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26251_XMLParser_A01 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String currentValue = null;

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if ("person".equals(qName)) {
            bName = true;
            bAge = true;
        } else if (bName && "name".equals(localName)) {
            bName = false;
        } else if (bAge && "age".equals(localName)) {
            bAge = false;
        } else if (bName && "name".equals(localName)) {
            currentValue = attributes.getValue("value");
        } else if (bAge && "age".equals(localName)) {
            currentValue = attributes.getValue("value");
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if ("person".equals(qName)) {
            // Process person node here
        } else if ("name".equals(qName)) {
            // Process name node here
        } else if ("age".equals(qName)) {
            // Process age node here
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XmlParser handler = new XmlParser();
            parser.parse("src/main/resources/people.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}