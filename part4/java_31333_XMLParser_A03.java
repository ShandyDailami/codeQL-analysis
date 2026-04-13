import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_31333_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(XMLParser.class.getResourceAsStream("/sample.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean isInsideElement = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isInsideElement = true;
            // This is where you would do your security-sensitive operation.
            // For example, check if the XML document contains an SQL injection or similar.
            System.out.println("Start of element: " + qName);
        }

        @Override
        public java_31333_XMLParser_A03(String uri, String localName, String qName) throws SAXException {
            isInsideElement = false;
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isInsideElement) {
                // This is where you would do your security-sensitive operation.
                // For example, check if the XML document contains an SQL injection or similar.
                System.out.println("Characters inside element: " + new String(ch, start, length));
            }
        }

    }
}