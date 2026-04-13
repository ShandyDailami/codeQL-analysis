import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40207_XMLParser_A03 {

    // DefaultHandler is a simple SAX handler that does not do anything with the data.
    private static class MyHandler extends DefaultHandler {
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
            String str = new String(ch, start, length);
            System.out.println("Characters: " + str);
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());

            // Load the XML file
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}