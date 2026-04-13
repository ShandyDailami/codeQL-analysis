import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.XMLReader;

public class java_35192_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ContentHandler());
            reader.parse("input.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class ContentHandler extends DefaultHandler {
        boolean bElement = false;
        String strElement = "";

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            bElement = true;
            strElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bElement) {
                strElement += new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            bElement = false;
            System.out.println(qName + " : " + strElement);
            strElement = "";
        }
    }
}