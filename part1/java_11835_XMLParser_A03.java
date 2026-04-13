import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXParserHelper;

public class java_11835_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParserHelper saxParser = null;

        try {
            saxParser = new SAXParserHelper(factory.newSAXParser(), new XMLHandler());
            saxParser.parse(new File("sample.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (saxParser != null) {
                saxParser.cleanup();
            }
        }
    }
}

class XMLHandler extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start Prefix Mapping: " + prefix + ", URI: " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("End Prefix Mapping: " + prefix + ", URI: " + uri);
    }
}