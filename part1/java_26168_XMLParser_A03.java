import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_26168_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new XMLEventHandler());
            parser.parse(new File("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class XMLEventHandler extends DefaultHandler {
        private StringBuffer buffer = new StringBuffer();
        private boolean inElement = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            buffer.setLength(0);
            inElement = true;
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (inElement) {
                System.out.println(qName + " : " + buffer.toString());
                inElement = false;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inElement) {
                buffer.append(ch, start, length);
            }
        }
    }
}