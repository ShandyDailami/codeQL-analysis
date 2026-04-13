import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_19076_XMLParser_A08 extends DefaultHandler {

    private boolean bName;
    private boolean bAge;
    private String currentElement;

    public java_19076_XMLParser_A08() {
        bName = false;
        bAge = false;
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of document.");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document.");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        } else {
            if (bName) {
                System.out.print("Name: ");
                bName = false;
            }

            if (bAge) {
                System.out.print("Age: ");
                bAge = false;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
            currentElement = "";
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLParser handler = new XMLParser();
            saxParser.parse(new File("src/main/resources/sample.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}