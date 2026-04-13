import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_34469_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse("src/main/resources/secure.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends BasicHandler {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
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
            String content = new String(ch, start, length);
            System.out.println("Character content: " + content);
        }

        @Override
        public void fatalError(String error) throws SAXException {
            System.out.println("Fatal error: " + error);
        }

        @Override
        public void warning(String msg) throws SAXException {
            System.out.println("Warning: " + msg);
        }
    }
}