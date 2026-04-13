import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_28900_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(XmlParser.class.getResourceAsStream("/sample.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;
        String qName = null;
        String age = null;
        String name = null;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            qName = localName;
            bName = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bName = false;
            bAge = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                name = new String(ch, start, length);
            }
            if (bAge) {
                age = new String(ch, start, length);
            }
        }

        @Override
        public void fatalError(SAXException e) throws SAXException {
            // Handle Fatal XML error
            System.out.println("Fatal Error: " + e.getMessage());
            e.printStackTrace();
        }

        @Override
        public void warning(SAXException e) throws SAXException {
            // Handle Warning
            System.out.println("Warning: " + e.getMessage());
        }

    }

}