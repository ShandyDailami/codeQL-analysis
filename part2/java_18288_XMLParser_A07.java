import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_18288_XMLParser_A07 extends DefaultHandler {
    private static final String TARGET_ELEMENT = "target";

    private boolean targetElementFound;

    public static void main(String[] args) {
        String xml = "<root><target>content</target></root>";
        new XMLParser().parse(xml);
    }

    public void parse(String xml) {
        SAXHelper helper = new SAXHelper() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equals(TARGET_ELEMENT)) {
                    targetElementFound = true;
                }
            }
        };
        helper.setContentHandler(this);
        helper.parse(xml);
        if (!targetElementFound) {
            System.out.println("Target element not found.");
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(TARGET_ELEMENT)) {
            targetElementFound = true;
        }
    }
}