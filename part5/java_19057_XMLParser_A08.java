import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_19057_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyContentHandler contentHandler = new MyContentHandler();
            saxParser.parse(inputFile, contentHandler);

            System.out.println("IntegrityFailure: " + contentHandler.getIntegrityFailure());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;
import org.xml.sax.Attributes;

class MyContentHandler extends DefaultHandler {

    private boolean integrityFailure = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        // This method is called when the start of an element is detected
    }

    public void endElement(String uri, String localName, String qName) {
        // This method is called when the end of an element is detected
    }

    public void characters(char[] ch, int start, int length) {
        // This method is called when characters are detected
    }

    public void error(SAXHelper saxHelper, SAXEvent event) {
        // This method is called when an error occurs
    }

    public void fatalError(SAXHelper saxHelper, SAXEvent event) {
        // This method is called when a fatal error occurs
    }

    public void warning(SAXHelper saxHelper, SAXEvent event) {
        // This method is called when a warning occurs
    }

    public void startPrefixMapping(String prefix, String uri) {
        // This method is called when a prefix mapping is started
    }

    public void endPrefixMapping(String prefix) {
        // This method is called when a prefix mapping is ended
    }

    public void setIntegrityFailure(boolean b) {
        integrityFailure = b;
    }

    public boolean getIntegrityFailure() {
        return integrityFailure;
    }
}