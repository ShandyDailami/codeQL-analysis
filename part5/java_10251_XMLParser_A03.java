import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;

public class java_10251_XMLParser_A03 extends DefaultHandler {

    private static final String INPUT_FILE = "input.xml";

    private static final String SAX_PACKAGE = "org.xml.sax";
    private static final String STREAM_PACKAGE = "java.io";

    private static final String SAX_PARSER_CLASS = SAX_PACKAGE + ".Parser";
    private static final String STREAM_INPUT_STREAM = STREAM_PACKAGE + ".InputStream";

    private SAXParser saxParser;
    private InputStream inputStream;

    private String lastElement;
    private boolean lastElementIsEmpty;

    public java_10251_XMLParser_A03() throws Exception {
        this.saxParser = (SAXParser) Class.forName(SAX_PARSER_CLASS).newInstance();
        this.saxParser.setContentHandler(this);
        this.inputStream = new FileInputStream(new File(INPUT_FILE));
        this.saxParser.parse(this.inputStream);
    }

    public static void main(String[] args) {
        try {
            new SecureXmlParser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElementIsEmpty = lastElement == null;
        if (lastElementIsEmpty) {
            System.out.print("Start Element: ");
        } else {
            System.out.print("Element: " + lastElement + " - ");
        }
        System.out.println("Local Name: " + localName);
        lastElement = localName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (lastElementIsEmpty) {
            System.out.print("End Element: ");
        } else {
            System.out.print("Element: " + lastElement + " - ");
        }
        System.out.println("Local Name: " + localName);
        lastElement = localName;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElementIsEmpty) {
            System.out.print("Characters: ");
        } else {
            System.out.print("Element: " + lastElement + " - ");
        }
        System.out.println(new String(ch, start, length));
    }

    public void error(SAXException e) {
        System.out.println("SAXException: " + e);
    }

    public void fatalError(SAXException e) {
        System.out.println("Fatal SAXException: " + e);
    }

    public void warning(SAXWarning warning) {
        System.out.println("SAXWarning: " + warning);
    }

}