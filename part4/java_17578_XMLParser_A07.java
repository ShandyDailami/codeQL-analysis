import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_17578_XMLParser_A07 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String tempValue = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        } else if (bName) {
            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            }
        } else if (bAge) {
            if (qName.equalsIgnoreCase("age")) {
                bAge = false;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            tempValue = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Name: " + tempValue + ", Age: " + tempValue);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new InputSource(new FileInputStream(inputFile)));
            MyXMLHandler myXMLHandler = new MyXMLHandler();
            saxParser.parse(inputFile, myXMLHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}