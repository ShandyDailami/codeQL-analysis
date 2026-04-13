// Import necessary libraries
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_19701_XMLParser_A01 {

    public void parse(String fileName) {
        File inputFile = new File(fileName);
        XMLReader xmlReader;

        try {
            // Create a new SAX parser
            xmlReader = XMLReaderFactory.createXMLReader();

            // Create a new SAX handler
            SaxHandler saxHandler = new SaxHandler();

            // Set the handler to the parser
            xmlReader.setContentHandler(saxHandler);

            // Parse the input file
            xmlReader.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "input.xml";  // replace with your file name
        new XMLParser().parse(fileName);
    }
}

class SaxHandler implements org.xml.sax.helpers.DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start Prefix Mapping: " + prefix + " -> " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("End Prefix Mapping: " + prefix + " -> " + uri);
    }
}