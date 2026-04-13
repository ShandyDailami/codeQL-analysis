import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14865_XMLParser_A08 {

    public static class MyHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start element: " + localName);
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End element: " + localName);
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            parser.parse(XMLParser.class.getResourceAsStream("example.xml"), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}