import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

public class java_12824_XMLParser_A03 {
    private static class MyHandler extends DefaultHandler {
        public void startDocument() throws SAXException {
            System.out.println("Document started");
        }

        public void endDocument() throws SAXException {
            System.out.println("Document ended");
        }

        public void startElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Element started: " + qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Element ended: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MyHandler handler = new MyHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse("src/example.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}