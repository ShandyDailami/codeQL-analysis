import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_41467_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);

        // Create a handler
        MyHandler handler = new MyHandler();

        // Parse the XML data
        try {
            parser.parse("src/data.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // MyHandler is a default handler for SAX events
    static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("Person")) {
                System.out.println("Start element: " + qName);
            } else if (qName.equalsIgnoreCase("Name")) {
                bName = true;
                System.out.println("Start element: " + qName);
            } else if (qName.equalsIgnoreCase("Age")) {
                bAge = true;
                System.out.println("Start element: " + qName);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("Person")) {
                System.out.println("End element: " + qName);
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Character data: " + new String(ch, start, length));
                bName = false;
            } else if (bAge) {
                System.out.println("Character data: " + new String(ch, start, length));
                bAge = false;
            }
        }
    }
}