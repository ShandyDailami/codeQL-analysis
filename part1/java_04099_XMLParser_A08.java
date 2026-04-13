import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04099_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        DefaultHandler defaultHandler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
                System.out.println("Start Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName)
                throws SAXException {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length)
                throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            saxParser.parse("input.xml", defaultHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}