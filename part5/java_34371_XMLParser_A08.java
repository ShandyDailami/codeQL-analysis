import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;
import org.xml.sax.Locator;
import java.io.File;
import java.io.IOException;

public class java_34371_XMLParser_A08 extends DefaultHandler {

    public java_34371_XMLParser_A08() throws IOException {
        // Load the XML file
        XMLLoader loader = new XMLLoader();
        loader.setErrorHandler(new XMLErrorHandler() {
            @Override
            public void warning(Locator locator, String msg, String detailedMsg, String Href) {
                System.out.println("Warning: " + msg);
            }

            @Override
            public void error(Locator locator, String msg, String detailedMsg, String Href) {
                System.out.println("Error: " + msg);
            }

            @Override
            public void fatalError(Locator locator, String msg, String detailedMsg, String Href) {
                System.out.println("Fatal Error: " + msg);
            }
        });
        loader.parse(new File("test.xml"));
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
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public static void main(String[] args) throws IOException {
        new MyXMLHandler();
    }
}