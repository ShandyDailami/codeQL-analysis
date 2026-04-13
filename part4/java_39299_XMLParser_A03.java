import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class java_39299_XMLParser_A03 extends DefaultHandler {

    private String lastElement;
    private boolean bName;
    private boolean bAge;

    public static void main(String[] args) {
        SAXParser saxParser = null;
        try {
            saxParser = org.xml.sax.SAXParserFactory.newInstance().newSAXParser();
            MyXMLParser handler = new MyXMLParser();
            saxParser.parse(new File("example.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        lastElement = qName;
        bName = false;
        bAge = false;

        if (qName.equals("person")) {
            System.out.println("Start of person");
        } else if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("age")) {
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("person")) {
            System.out.println("End of person");
        } else if (qName.equals("name")) {
            bName = false;
        } else if (qName.equals("age")) {
            bAge = false;
        }

        lastElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}