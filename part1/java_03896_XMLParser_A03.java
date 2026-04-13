import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_03896_XMLParser_A03 extends DefaultHandler {

    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start element: " + qName);
        // Security sensitive operation, perform A03_Injection here, e.g.
        String injection = attributes.getValue("injection");
        // ...
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        System.out.println("Character data: " + value);
        // Security sensitive operation, perform A03_Injection here, e.g.
        // ...
    }

    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void warning(SAXWarning e) {
        System.out.println("Warning: " + e.getMessage());
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(parser);
            saxParser.setProperty("http://xml.org/sax/features","http://xml.org/sax/features/namespace-prefixes");

            saxParser.parse("src/main/resources/example.xml", parser);
        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}