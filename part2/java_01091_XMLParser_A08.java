import java.util.StringTokenizer;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01091_XMLParser_A08 {
    public static class MyHandler extends DefaultHandler {
        private String thisElement;
        
        public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
            thisElement = qName;
        }

        public void endElement(String uri, String localName, String qName)
            throws SAXException {
            thisElement = "";
        }

        public void characters(char[] ch, int start, int length)
            throws SAXException {
            if (thisElement.equals("name")) {
                String value = new String(ch, start, length);
                System.out.println(value);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(args[0], handler);
    }
}