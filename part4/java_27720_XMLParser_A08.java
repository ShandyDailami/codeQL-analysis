import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_27720_XMLParser_A08 {

    // This is our default handler. Any element not declared in the handler will be passed
    // to the default handler.
    public static class MyDefaultHandler extends DefaultHandler {

        private StringBuilder stringBuilder;
        private int depth;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            depth++;
            stringBuilder.append("    ").append(repeat("  ", depth));
            stringBuilder.append("<").append(localName);
            if (attributes.getLength() > 0) {
                stringBuilder.append(" ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    stringBuilder.append(attributes.getQName(i)).append("=\"")
                            .append(attributes.getValue(i)).append("\" ");
                }
            }
            stringBuilder.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            depth--;
            stringBuilder.append("</").append(localName).append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            stringBuilder.append(ch, start, length);
        }

        private String repeat(String str, int times) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < times; i++) {
                builder.append(str);
            }
            return builder.toString();
        }
    }

    public static void parse(String xml) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, new MyDefaultHandler(new StringBuilder()));
        saxParser.parse(xml);
        System.out.println(saxParser.getContent().toString());
    }

    public static void main(String[] args) throws Exception {
        String xml = "<doc><message>Hello, world!</message></doc>";
        parse(xml);
    }
}