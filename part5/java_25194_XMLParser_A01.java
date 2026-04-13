import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_25194_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "BrokenAccessControl.xml";
        parseXML(xmlFile);
    }

    private static void parseXML(String xmlFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(new InputSource(new File(xmlFile)));

            // Create a new Handler for the XML document
            SAXHandler handler = new SAXHandler();

            // Set the handler to the parser
            parser.setContentHandler(handler);

            // Parsing the XML document
            parser.parse(new File(xmlFile));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {

    private boolean bName;
    private boolean bId;
    private boolean bAge;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of the document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of the document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Start of " + qName);
            bName = true;
            bId = true;
            bAge = true;

            System.out.println("Name, ID, Age");
        } else if (bName && qName.equalsIgnoreCase("name")) {
            System.out.print("Name : ");
            bName = false;
        } else if (bName && qName.equalsIgnoreCase("id")) {
            System.out.print("ID : ");
            bId = false;
        } else if (bId && qName.equalsIgnoreCase("age")) {
            System.out.println("Age");
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End of " + qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.print(new String(ch, start, length));
        } else if (bId) {
            System.out.print(new String(ch, start, length));
        } else if (bAge) {
            System.out.println(new String(ch, start, length));
        }
    }

    @Override
    public void warning(SAXParseException e) {
        System.out.println("Warnings: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("Errors: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}