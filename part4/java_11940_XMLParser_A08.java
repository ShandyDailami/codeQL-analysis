import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11940_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("example.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean bTag = false;
        private String currentElement = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentElement = qName;
            bTag = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;
            currentElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                System.out.println(currentElement + " : " + new String(ch, start, length));
            }
        }
    }
}