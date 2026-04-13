import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_26542_XMLParser_A01 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private boolean bCity = false;
    private String name = null;
    private int age = 0;
    private String city = null;

    public java_26542_XMLParser_A01() {
        // Initialize the boolean flags to false
        bName = bAge = bCity = false;
    }

    public void startDocument() throws SAXException {
        // Initialize the count of elements
        System.out.println("Start of document");
    }

    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        // Determine which elements to print
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("\nPerson details:");
            return;
        }

        if (qName.equalsIgnoreCase("name")) {
            bName = true;
            return;
        }

        if (qName.equalsIgnoreCase("age")) {
            bAge = true;
            return;
        }

        if (qName.equalsIgnoreCase("city")) {
            bCity = true;
            return;
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // End of an element
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End of person details");
            return;
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // Get the characters
        if (bName) {
            name = new String(ch, start, length);
            System.out.println("Name: " + name);
            bName = false;
            return;
        }

        if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
            System.out.println("Age: " + age);
            bAge = false;
            return;
        }

        if (bCity) {
            city = new String(ch, start, length);
            System.out.println("City: " + city);
            bCity = false;
            return;
        }
    }

    public void endDocument() throws SAXException {
        // End of the document
        System.out.println("End of document");
    }

    public static void main(String[] args) {
        try {
            // Create a SAX parser
            XMLReader parser = XMLReaderFactory.createXMLReader();
            parser.setContentHandler(new XMLParser());

            // Parse the XML file
            File inputFile = new File("data.xml");
            parser.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}