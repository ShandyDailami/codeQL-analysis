import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_04648_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());

            // parse the XML file
            parser.parse(new File("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder builder;

        public java_04648_XMLParser_A07() {
            builder = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            builder.append("<");
            builder.append(qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                builder.append(" ");
                builder.append(attributes.getQName(i));
                builder.append("=\"");
                builder.append(attributes.getValue(i));
                builder.append("\"");
            }
            builder.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            builder.append("</");
            builder.append(qName);
            builder.append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            builder.append(ch, start, length);
        }

        @Override
        public void endDocument() {
            System.out.println(builder.toString());
        }
    }
}