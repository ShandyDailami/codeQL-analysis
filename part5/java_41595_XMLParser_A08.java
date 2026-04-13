import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_41595_XMLParser_A08 {

    public static class CustomHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Characters: " + content);
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) {
            System.out.println("Start of prefix mapping: " + prefix + " - " + uri);
        }

        @Override
        public void endPrefixMapping(String prefix) {
            System.out.println("End of prefix mapping: " + prefix);
        }

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

    public static void main(String[] args) {
        String xml = "<document><message>Hello, World!</message></document>";
        parse(xml, CustomHandler.class);
    }

    public static void parse(String xml, Class<? extends SAXHandler> handlerClass) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handlerClass);
            InputSource is = new StringReader(xml);
            parser.parse(is, CustomHandler.class);
        } catch (Exception e) {
            System.out.println("Parsing failed: " + e.getMessage());
        }
    }
}