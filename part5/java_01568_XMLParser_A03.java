import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_01568_XMLParser_A03 {
    private static class XMLHandler extends DefaultHandler {
        private static final String AUTHOR = "author";
        private static final String TITLE = "title";
        private static final String YEAR = "year";

        private String lastTag = null;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastTag = qName;
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(lastTag)) {
                System.out.println("Security violation detected: " + localName);
            }
            lastTag = null;
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            XMLHandler xmlHandler = new XMLHandler();
            saxParser.parse(new File("books.xml"), xmlHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}