import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class java_37166_XMLParser_A01 extends DefaultHandler {

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/data.xml"; // Provide your XML file path
        File xmlFile = new File(xmlFilePath);

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(xmlFile.toURI().toURL());

            saxParser.parse(xmlFile, this);

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing XML document...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Finished parsing XML document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Starting element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Ending element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Character data: " + new String(ch, start, length));
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}