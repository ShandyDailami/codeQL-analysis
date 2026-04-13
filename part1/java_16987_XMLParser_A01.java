import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_16987_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());

            // Parsing the XML file
            saxParser.parse(XmlParser.class.getResourceAsStream("/broken_access_control.xml"), true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handler for SAX Parsing
    static class MyHandler extends DefaultHandler {

        private StringBuffer buffer;

        @Override
        public void startDocument() throws SAXException {
            buffer = new StringBuffer();
        }

        @Override
        public void endDocument() throws SAXException {
            String text = buffer.toString();
            System.out.println(text);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            buffer.append("<");
            buffer.append(qName);

            // Adding attributes
            if (attributes.getLength() > 0) {
                buffer.append(" ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    buffer.append(attributes.getQName(i) + "=" + attributes.getValue(i) + " ");
                }
            }

            buffer.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            buffer.append("</");
            buffer.append(qName);
            buffer.append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            buffer.append(new String(ch, start, length));
        }

    }
}