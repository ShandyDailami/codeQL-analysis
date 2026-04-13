import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_07284_XMLParser_A01 extends DefaultHandler {
    public void startDocument() {
        System.out.println("Start of the document");
    }

    public void endDocument() {
        System.out.println("End of the document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length).trim();
        if (content.length() > 0) {
            System.out.println("Content: " + content);
        }
    }

    public void warning(SAXParseException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public void fatalError(SAXParseException e) {
        System.out.println("Fatal error: " + e.getMessage());
    }
}

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String input = "<person><name>John</name><age>30</age></person>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MySAXHandler());

        parser.parse(new InputSource(new StringReader(input)));
    }
}