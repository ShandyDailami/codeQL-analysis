import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.XMLStreamReader;
import javax.xml.parsers.XMLParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_22185_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            String xmlFile = "src/main/resources/example.xml";
            XMLStreamReader xmlStreamReader = saxParser.createXMLStreamReader(xmlFile);

            saxParser.setContentHandler(new XmlContentHandler(xmlStreamReader));
            saxParser.parse(xmlStreamReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XmlContentHandler extends DefaultHandler {
        private XMLStreamReader xmlStreamReader;

        public java_22185_XMLParser_A03(XMLStreamReader xmlStreamReader) {
            this.xmlStreamReader = xmlStreamReader;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start element: " + qName);
            // Process start element
            // For example, print out attributes if any
            if (attributes.getLength() > 0) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
            // Process end element
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
            // Process characters
        }
    }
}