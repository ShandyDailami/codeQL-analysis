import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class java_12437_XMLParser_A08 extends DefaultHandler {

    private boolean bName;
    private boolean bAge;
    private String tempValue;

    public java_12437_XMLParser_A08() {
        bName = false;
        bAge = false;
    }

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        }
        System.out.print("Start Element : " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element : " + qName);
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name : " + new String(ch, start, length));
        }
        if (bAge) {
            System.out.println("Age : " + new String(ch, start, length));
        }
        tempValue = new String(ch, start, length);
    }

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(inputFile.toURI().toURL(), MyXMLHandler.class);
            saxParser.parse(inputFile, MyXMLHandler.class);
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}