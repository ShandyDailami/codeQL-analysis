import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_15708_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            DefaultHandler defaultHandler = new DefaultHandler();

            saxParser.parse(XMLParser.class.getResourceAsStream("sample.xml"), defaultHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        // Security-sensitive operation: No output
    }

    public void endElement(String uri, String localName, String qName) {
        // Security-sensitive operation: No output
    }

    public void characters(char[] ch, int start, int length) {
        // Security-sensitive operation: No output
    }
}