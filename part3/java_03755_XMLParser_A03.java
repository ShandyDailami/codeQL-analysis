import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_03755_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ContentHandler());

            // Load the XML file
            reader.parse("src/main/resources/data.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class ContentHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            }
            if (qName.equals("name")) {
                bName = false;
            }
            if (qName.equals("age")) {
                bAge = false;
            }
        }

        @Override
        public java_03755_XMLParser_A03(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equals("person")) {
                System.out.println("End of person");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            }
            if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}