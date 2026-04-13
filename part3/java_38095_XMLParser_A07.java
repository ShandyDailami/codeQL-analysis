import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_38095_XMLParser_A07 extends DefaultHandler {
    private boolean bName = false;
    private boolean bNumber = false;

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxFactory.newSAXParser();

            MyXMLHandler myHandler = new MyXMLHandler();
            saxParser.parse(new File("sample.xml"), myHandler);

        } catch (Exception e) {
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
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("number")) {
            bNumber = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (qName.equalsIgnoreCase("number")) {
            bNumber = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bNumber) {
            System.out.println("Number: " + new String(ch, start, length));
        }
    }
}