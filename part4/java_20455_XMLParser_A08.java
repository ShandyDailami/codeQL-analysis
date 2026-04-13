import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_20455_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null);
            XMLReader reader = parser.getXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(new File("input.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private StringBuilder buffer;

        public java_20455_XMLParser_A08() {
            buffer = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            buffer.setLength(0);
            buffer.append("<");
            buffer.append(qName);
            if (attributes.getLength() > 0) {
                buffer.append(" ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    buffer.append(attributes.getQName(i));
                    buffer.append("=\"");
                    buffer.append(attributes.getValue(i));
                    buffer.append("\" ");
                }
            }
            buffer.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            buffer.append(buffer.substring(buffer.length() - 1)); // remove the last >
            buffer.append("</");
            buffer.append(qName);
            buffer.append(">");
            System.out.println(buffer.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            buffer.append(ch, start, length);
        }
    }
}