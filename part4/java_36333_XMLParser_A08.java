import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_36333_XMLParser_A08 extends DefaultHandler {
    private boolean bName;
    private String strName;

    public java_36333_XMLParser_A08() {
        bName = false;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("name")) {
            bName = true;
            strName = "";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) {
            // Do some secure operation related to integrity failure
            // For example, check if the string is empty
            if (strName.isEmpty()) {
                throw new SecurityException("Empty name found");
            }
            bName = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            strName = new String(ch, start, length);
        }
    }

    public static void main(String[] args) throws Exception {
        String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<root>" +
                "<name>John</name>" +
                "</root>";

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        SecureXMLParser handler = new SecureXMLParser();
        saxParser.parse(new InputSource(new StringReader(xmlData)), handler);
    }
}