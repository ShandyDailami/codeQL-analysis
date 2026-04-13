import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_34163_XMLParser_A08 {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(new File("path_to_your_xml_file"), new MyHandler());
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder buffer;
        private boolean bNode = false;
        private String currentElement = "";

        @Override
        public void startDocument() throws SAXException {
            buffer = new StringBuilder();
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println(buffer.toString());
        }

        @Override
        public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
            buffer.append("<");
            buffer.append(qualifiedName);
            if (attributes.getLength() > 0) {
                buffer.append(" ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    buffer.append(attributes.getQualifiedPrefix(i) + ":" + attributes.getValue(i));
                    if (i < attributes.getLength() - 1) {
                        buffer.append(", ");
                    }
                }
            }
            buffer.append(">");
            bNode = true;
            currentElement = qualifiedName;
        }

        @Override
        public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
            if (bNode) {
                buffer.append("</");
                buffer.append(currentElement);
                buffer.append(">");
                bNode = false;
            } else {
                buffer.append("</");
                buffer.append(qualifiedName);
                buffer.append(">");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bNode) {
                buffer.append(new String(ch, start, length));
            }
        }
    }
}