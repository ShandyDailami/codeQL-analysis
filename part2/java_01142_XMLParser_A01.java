import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_01142_XMLParser_A01 {
    public static void main(String[] args) {
        String url = "http://example.com/books.xml"; // replace with your XML file URL
        XMLParser parser = new XMLParser();
        parser.parse(url, new DefaultHandler() {
            public void startDocument() {
                System.out.println("Start Document");
            }

            public void endDocument() {
                System.out.println("End Document");
            }

            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                System.out.println("Characters: " + new String(ch, start, length));
            }

            public void fatalError(String error) {
                System.out.println("Fatal Error: " + error);
            }

            public void warning(String warning) {
                System.out.println("Warning: " + warning);
            }
        });
    }

    public void parse(String url, DefaultHandler handler) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(new InputSource(url));
            saxParser.setContentHandler(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}