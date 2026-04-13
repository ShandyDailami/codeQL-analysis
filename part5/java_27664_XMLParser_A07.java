import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_27664_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "path/to/your/xml/file.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XMLErrorHandler());
            parser.parse(xmlFile, new XMLEventHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLEventHandler extends DefaultHandler {
        private boolean isStartElement = true;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (isStartElement) {
                System.out.println("Start Element: " + qName);
                isStartElement = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isStartElement) {
                System.out.println("Character Data: " + new String(ch, start, length));
            }
        }
    }

    static class XMLErrorHandler extends DefaultHandler {
        @Override
        public void warning(SAXParseException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}