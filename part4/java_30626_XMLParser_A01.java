import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_30626_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            BasicHandler handler = new BasicHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // The broken code
            reader.setContentHandler(handler);

            // This line should not be commented out
            reader.parse("example.xml");

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class BasicHandler extends BasicHandler {
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            System.out.println("Ignorable whitespace: " + new String(ch, start, length));
        }
    }
}