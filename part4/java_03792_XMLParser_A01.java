import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_03792_XMLParser_A01 {

    public void parse(String file) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new DefaultHandler());
            reader.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private class DefaultHandler extends org.xml.sax.helpers.DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Start element: " + localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}