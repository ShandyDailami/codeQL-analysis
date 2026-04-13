import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_16330_XMLParser_A03 {
    private static class MyHandler extends DefaultHandler {
        public void startDocument() {
            System.out.println("Start of document.");
        }
        public void endDocument() {
            System.out.println("End of document.");
        }
        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start of element " + qName);
        }
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element " + qName);
        }
        public void characters(char[] chars, int start, int length) {
            String str = new String(chars, start, length);
            System.out.println("Character data: " + str);
        }
        public void error(SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }
        public void fatalError(SAXException e) {
            System.out.println("Fatal error: " + e.getMessage());
        }
        public void warning(SAXWarning warning) {
            System.out.println("Warning: " + warning.getMessage());
        }
    }
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\"?>\n" +
                "<root>\n" +
                "  <element1>Content 1</element1>\n" +
                "  <element2>Content 2</element2>\n" +
                "</root>";
        parse(xml, MyHandler.class);
    }
    public static void parse(String xml, Class<? extends DefaultHandler> handlerClass) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handlerClass);
            SAXSource source = new SAXSource(new StringReader(xml), handlerClass);
            parser.parse(source, false);
        } catch (Exception e) {
            System.out.println("Parsing failed: " + e.getMessage());
        }
    }
}