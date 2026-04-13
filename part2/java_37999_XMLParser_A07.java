import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_37999_XMLParser_A07 {

    public static class MyHandler extends DefaultHandler {
        private String lastElement;
        private String lastQName;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElement = qName;
            lastQName = localName;
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(lastElement)) {
                System.out.println("End of " + lastQName);
            }
            lastElement = null;
            lastQName = null;
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastElement != null && lastElement.equals(lastQName)) {
                String data = new String(ch, start, length);
                System.out.println("Data: " + data.trim());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse(XMLParser.class.getResourceAsStream("test.xml"), handler);
    }
}