import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;

public class java_03085_XMLParser_A08 {

    private static class MyHandler extends DefaultHandler {
        private boolean tagFound = false;
        private String lastElement = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("A08_IntegrityFailure".equals(localName)) {
                tagFound = true;
                lastElement = qName;
            }
        }

        @Override
        public java_03085_XMLParser_A08(String uri, String localName, String qName) throws SAXException {
            if (tagFound) {
                System.out.println("Security failure detected in tag: " + lastElement);
                tagFound = false;
            }
        }
    }

    public static void parse(String file) {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser(new InputSource(new File(file)));
        MyHandler handler = new MyHandler();
        saxParser.parse(new InputSource(new File(file)), handler);
    }
}