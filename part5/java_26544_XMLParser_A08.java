import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26544_XMLParser_A08 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentValue = null;

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MinimalistXMLParser handler = new MinimalistXMLParser();
            saxParser.parse(MinimalistXMLParser.class.getResourceAsStream("people.xml"), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("person".equals(qName)) {
            bName = true;
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("name".equals(qName)) {
            bName = false;
        } else if ("age".equals(qName)) {
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            currentValue = new String(ch, start, length);
        }
    }

    @Override
    public void error(SAXException e) {
        e.printStackTrace();
    }

    @Override
    public void fatalError(SAXException e) {
        e.printStackTrace();
    }

    @Override
    public void warning(SAXException e) {
        e.printStackTrace();
    }
}