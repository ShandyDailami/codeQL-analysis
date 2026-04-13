import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;

public class java_10224_XMLParser_A01 extends DefaultHandler {

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

    public static void main(String[] args) {
        try {
            XMLParser parser = new SAXParser();
            XMLLoader loader = new XMLLoader(new MyHandler());
            parser.setErrorHandler(new XMLErrorHandler() {
                public void warning(SAXParseException e) {
                    System.out.println("SAXWarning: " + e.getMessage());
                }

                public void error(SAXParseException e) {
                    System.out.println("SAXError: " + e.getMessage());
                }

                public void fatalError(SAXParseException e) {
                    System.out.println("SAXFatalError: " + e.getMessage());
                }
            });
            parser.parse(new File("example.xml"));
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}