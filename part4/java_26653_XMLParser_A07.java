import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26653_XMLParser_A07 {

    public static void main(String[] args) {
        String xml = "<root><element1>content1</element1><element2>content2</element2></root>";
        parseXml(xml);
    }

    private static void parseXml(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler(xml));
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {

        private StringBuilder builder;

        public java_26653_XMLParser_A07(String xml) {
            builder = new StringBuilder();
            builder.append(xml);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            builder.append("<").append(qName);
            if (attributes.getLength() > 0) {
                builder.append(" ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    builder.append(attributes.getQName(i));
                    builder.append("='").append(attributes.getValue(i)).append("' ");
                }
            }
            builder.append("/>");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Do something here
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Do something here
        }
    }
}