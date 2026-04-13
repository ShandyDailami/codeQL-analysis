import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLStreamReader;
import org.xml.sax.parser.XMLEventWriter;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class java_14282_XMLParser_A01 {

    private static final String BROKEN_ACCESS_CONTROL_XML = "broken_access_control.xml";

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new InputStreamReader(new FileInputStream(BROKEN_ACCESS_CONTROL_XML)));

            saxParser.setProperty("http://xml.org/sax/features","true");
            saxParser.setProperty("http://xml.org/sax/features","lang");

            // Set up a handler to handle the XML elements
            DefaultHandler defaultHandler = new DefaultHandler() {

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Handle the start of an element here
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    // Handle the end of an element here
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    // Handle characters here
                }

                @Override
                public void startPrefixMapping(String prefix, String uri) throws SAXException {
                    // Handle start of a prefix mapping here
                }

                @Override
                public void endPrefixMapping(String prefix) throws SAXException {
                    // Handle end of a prefix mapping here
                }

            };

            // Parse the XML
            saxParser.parse(BROKEN_ACCESS_CONTROL_XML, defaultHandler);

            System.out.println("Broken Access Control Policy Parsed Successfully!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}