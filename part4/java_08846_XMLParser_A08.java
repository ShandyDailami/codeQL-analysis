import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.SAXEntry;
import org.xml.sax.ext.DefaultHandler;

public class java_08846_XMLParser_A08 {

    public static void main(String[] args) {
        SAXHandler handler = new SAXHandler();
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(handler);

        try {
            reader.parse("src/main/resources/example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        private boolean bElement = false;
        private String strElement = "";
        private boolean bAttribute = false;
        private String strAttribute = "";

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            bElement = true;
            strElement = qName;
            printAttributes(attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            bElement = false;
            strElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bElement) {
                strElement += new String(ch, start, length);
            }
        }

        private void printAttributes(org.xml.sax.Attributes attributes) {
            for (int i = 0; i < attributes.getLength(); i++) {
                bAttribute = true;
                strAttribute = attributes.getValue(i);
                System.out.println("Attribute: " + strAttribute);
            }
        }
    }
}