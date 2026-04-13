import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_02753_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XmlHandler handler = new XmlHandler();
        parser.parse(XmlParser.class.getResourceAsStream("/sample.xml"), handler);
    }

    private static class XmlHandler extends DefaultHandler {

        private boolean isTitle = false;
        private boolean isLink = false;
        private boolean isDescription = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("link")) {
                isLink = true;
            } else if (qName.equalsIgnoreCase("description")) {
                isDescription = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = false;
            } else if (qName.equalsIgnoreCase("link")) {
                isLink = false;
            } else if (qName.equalsIgnoreCase("description")) {
                isDescription = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (isLink) {
                System.out.println("Link: " + new String(ch, start, length));
            } else if (isDescription) {
                System.out.println("Description: " + new String(ch, start, length));
            }
        }
    }
}