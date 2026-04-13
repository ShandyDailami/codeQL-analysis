import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class java_26197_XMLParser_A03 extends DefaultHandler {
    private XMLParser parser;

    public java_26197_XMLParser_A03() {
        try {
            parser = new XMLParser(new MyHandler(), new XMLErrorHandler() {
                public void warning(SAXParseException e) {
                }
                public void error(SAXParseException e) {
                    throw e;
                }
                public void fatalError(SAXParseException e) {
                    throw e;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        System.out.println("Start of element " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public void parse(String file) throws IOException, SAXException {
        parser.parse(new File(file));
    }
}