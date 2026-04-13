import java.net.URL;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_11671_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/test.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            MyHandler handler = new MyHandler();
            saxParser.parse(url.openStream(), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName,
            javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        System.out.println("Start element: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws javax.xml.parsers.SAXException {
        System.out.println("End element: " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws javax.xml.parsers.SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
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
        System.out.println("Fatal error: " + e.getMessage());
    }
}