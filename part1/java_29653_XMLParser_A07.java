import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class java_29653_XMLParser_A07 extends DefaultHandler {
    private boolean bUsername = false;
    private boolean bPassword = false;

    public static void main(String[] args) {
        String fileName = "sample.xml";
        File inputFile = new File(fileName);

        try {
            SecureXMLParser parser = new SecureXMLParser();
            org.xml.sax.SAXParserFactory factory = org.xml.sax.SAXParserFactory.newInstance();
            org.xml.sax.SAXParser saxParser = factory.newSAXParser(inputFile.toURI().toString());

            saxParser.setProperty("http://xml.org/sax/properties/external-general-namespace", "false");
            saxParser.setProperty("http://xml.org/sax/properties/load-dtd", "false");
            saxParser.setProperty("http://xml.org/sax/properties/load-external-schema", "false");
            saxParser.setProperty("http://xml.org/sax/properties/dtd-validation", "false");
            saxParser.setProperty("http://xml.org/sax/properties/external-dtd", "false");
            saxParser.setProperty("http://xml.org/sax/properties/normalization-before", "false");
            saxParser.setProperty("http://xml.org/sax/properties/external-dtd-prefix", "false");

            saxParser.parse(inputFile, parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("username") && attributes.getValue("type").equalsIgnoreCase("password")) {
            bUsername = true;
            bPassword = false;
        } else if (qName.equalsIgnoreCase("password") && attributes.getValue("type").equalsIgnoreCase("username")) {
            bPassword = true;
            bUsername = false;
        } else if (qName.equalsIgnoreCase("secureElement")) {
            if (bUsername && bPassword) {
                System.out.println("Encrypted Element Found");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Do Nothing
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Do Nothing
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: Line " + e.getLineNumber() + ", Message: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: Line " + e.getLineNumber() + ", Message: " + e.getMessage());
    }
}