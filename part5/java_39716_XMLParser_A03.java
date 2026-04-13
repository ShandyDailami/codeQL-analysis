import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_39716_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            String xml = "<root><name>John</name><age>25</age><city>New York</city></root>";
            parse(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parse(String xml) throws SAXException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new MyContentHandler());
        reader.parse(new InputSource(new StringReader(xml)));
    }

    private static class MyContentHandler extends DefaultHandler {

        private StringBuilder builder = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            builder.setLength(0);
            builder.append("<").append(qName).append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            builder.append("</").append(qName).append(">");
            System.out.println(builder.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            builder.append(new String(ch, start, length));
        }
    }
}