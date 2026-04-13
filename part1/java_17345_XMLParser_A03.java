import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_17345_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a new instance of the XMLReader
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create a new instance of the SAXParser
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

            // Create a new instance of the Handler
            SAXHandler handler = new SAXHandler();

            // Parse the XML file
            saxParser.parse(new InputSource(new File("src/main/resources/sample.xml")), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler implements SAXHandlerInterface {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + localName);
    }

    @Override
    public void characters(String chars, int start, int length) throws SAXException {
        System.out.println("Characters: " + chars);
    }
}

interface SAXHandlerInterface extends SAXListener {
    void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException;
    void endElement(String uri, String localName, String qName) throws SAXException;
    void characters(String chars, int start, int length) throws SAXException;
}