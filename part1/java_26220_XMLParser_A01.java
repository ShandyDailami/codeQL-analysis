import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26220_XMLParser_A01 extends DefaultHandler {

    private boolean bAccessControl;

    public java_26220_XMLParser_A01(boolean bAccessControl) {
        this.bAccessControl = bAccessControl;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (bAccessControl) {
            if (localName.equals("element")) {
                String attribute = attributes.getValue("access");
                if (!"secure".equals(attribute)) {
                    throw new SAXException("Broken Access Control: Attempt to access not secured resource.");
                }
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            XMLParser xmlParser = new XMLParser(true);
            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("brokenAccessControl.xml"), xmlParser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}