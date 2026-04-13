import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_23218_XMLParser_A03 {

    public static void parse(String filename) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            saxParser.parse(filename, new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private StringBuilder sb;

        @Override
        public void startDocument() {
            sb = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            sb.append("<");
            sb.append(qName);
            appendAttributes(attributes);
            sb.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            sb.append("</");
            sb.append(qName);
            sb.append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            sb.append(new String(ch, start, length));
        }

        private void appendAttributes(Attributes attributes) {
            if (attributes.getLength() > 0) {
                sb.append(" ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    sb.append(attributes.getQName(i));
                    sb.append("=");
                    sb.append("\"");
                    sb.append(attributes.getValue(i));
                    sb.append("\"");
                    if (i < attributes.getLength() - 1) {
                        sb.append(" ");
                    }
                }
            }
        }

        @Override
        public void endDocument() {
            System.out.println(sb.toString());
        }
    }
}