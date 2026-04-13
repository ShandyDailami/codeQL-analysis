import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XPCOMHandler;
import org.xml.sax.parser.XPCOMReader;

public class java_37271_XMLParser_A03 {

    public static void main(String[] args) {

        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        SAXParserHandler handler = new SAXParserHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            XMLReader reader = factory.newSAXParser().getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SAXParserHandler extends DefaultHandler {
        private String lastElementLocalName;

        @Override
        public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
            lastElementLocalName = localName;
            System.out.println("Start element: " + localName);
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
            lastElementLocalName = null;
            System.out.println("End element: " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastElementLocalName != null) {
                System.out.println("Character data: " + new String(ch, start, length));
            }
        }
    }
}