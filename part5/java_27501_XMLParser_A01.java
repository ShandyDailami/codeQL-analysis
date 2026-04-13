import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class java_27501_XMLParser_A01 extends DefaultHandler {

    private static final String PATH = "yourfile.xml";

    public java_27501_XMLParser_A01() {
        XMLParser parser = new SAXParserImpl();
        parser.setErrorHandler(new XMLErrorHandler() {
            @Override
            public void fatalError(final SAXParseException e) {
                System.out.println("Fatal error: " + e.getMessage());
            }

            @Override
            public void warning(final SAXParseException e) {
                System.out.println("Warning: " + e.getMessage());
            }

            @Override
            public void error(final SAXParseException e) {
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void severeWarning(final SAXParseException e) {
                System.out.println("Severe warning: " + e.getMessage());
            }

            @Override
            public void info(final SAXParseException e) {
                System.out.println("Info: " + e.getMessage());
            }
        });

        try {
            InputStream inputStream = Files.newInputStream(Paths.get(PATH));
            parser.parse(inputStream, this);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        System.out.println("Start element: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public static void main(String[] args) {
        new SecureXMLParser();
    }
}