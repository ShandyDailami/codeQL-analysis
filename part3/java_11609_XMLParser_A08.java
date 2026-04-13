import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_11609_XMLParser_A08 {

    public static class CustomHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void startPrefixMapping(String prefix, String uri)
                throws SAXException {
            System.out.println("Prefix mapping: prefix=" + prefix + ", uri=" + uri);
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            System.out.println("End prefix mapping: " + prefix);
        }

    }

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new CustomHandler());
            reader.parse("src/main/resources/test.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}