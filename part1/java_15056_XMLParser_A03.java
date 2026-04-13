import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_15056_XMLParser_A03 {
    public static void parse(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SecureSAXHandler(file));
            parser.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SecureSAXHandler extends DefaultHandler {
        private String file;

        public java_15056_XMLParser_A03(String file) {
            this.file = file;
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document: " + file);
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document: " + file);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName + " in " + localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName + " in " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length);
            System.out.println("Character content: " + content);
        }

        @Override
        public void fatalError(SAXException e) throws SAXException {
            System.out.println("Fatal error: " + e.getMessage());
        }

        @Override
        public void error(SAXException e) throws SAXException {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        parse("src/main/resources/example.xml");
    }
}