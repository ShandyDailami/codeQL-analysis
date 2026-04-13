import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_38914_XMLParser_A01 extends DefaultHandler {
    private boolean parsingFailed;

    public static void main(String[] args) {
        try {
            MyXMLParser parser = new MyXMLParser();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(null, parser);
            saxParser.parse("src/test.xml", parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public java_38914_XMLParser_A01() {
        parsingFailed = false;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void error(SAXException e) {
        parsingFailed = true;
        System.out.println("Parsing failed: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        parsingFailed = true;
        System.out.println("Fatal error: " + e.getMessage());
    }

    @Override
    public void warning(SAXWarning warning) {
        System.out.println("Warning: " + warning.getMessage());
    }

    public boolean isParsingFailed() {
        return parsingFailed;
    }
}