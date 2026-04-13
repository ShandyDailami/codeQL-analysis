import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

public class java_24773_XMLParser_A01 {
    public static void main(String[] args) {
        String xml = "<root><element>Content</element></root>";
        try {
            SAXHandler handler = new SAXHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse("<root><encrypted>" + xml + "</encrypted></root>");
            System.out.println(handler.getContent());
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        private StringBuilder content;

        public java_24773_XMLParser_A01() {
            content = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, java.util.Properties properties) throws SAXException {
            content.append("<").append(qName);
            super.startElement(uri, localName, qName, properties);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            content.append(">").append(contentOrDefault(qName, "</").append(qName).append(">");
            super.endElement(uri, localName, qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            content.append(new String(ch, start, length));
            super.characters(ch, start, length);
        }

        private String contentOrDefault(String qName, String def) {
            return content.length() == 0 ? def : content.toString();
        }
    }
}