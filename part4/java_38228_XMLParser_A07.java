import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

public class java_38228_XMLParser_A07 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;

    public java_38228_XMLParser_A07() {
        System.out.println("Starting XML Parsing...");
    }

    public void startDocument() {
        System.out.println("Start Document");
    }

    public void endDocument() {
        System.out.println("End Document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
            System.out.println("Start Person Element: " + qName);
        } else if (bName && qName.equalsIgnoreCase("name")) {
            System.out.println("Start Name Element: " + qName);
            bName = false;
        } else if (bAge && qName.equalsIgnoreCase("age")) {
            System.out.println("Start Age Element: " + qName);
            bAge = false;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End Person Element: " + qName);
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (bName) {
            System.out.println("Person Name: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Person Age: " + new String(ch, start, length));
        }
    }

    public void error(SAXParseException e) {
        System.out.println("SAXParseException: " + e.getMessage());
    }

    public void fatalError(SAXParseException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void warning(SAXParseException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    public static void main(String[] args) {
        try {
            String filename = "sample.xml";
            InputStream in = new FileInputStream(filename);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyXMLHandler());
            reader.parse(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}