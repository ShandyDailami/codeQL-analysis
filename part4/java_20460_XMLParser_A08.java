import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_20460_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml"); // provide your xml file path
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();

            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(myHandler);

            saxParser.parse(xmlFile, myHandler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {
    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws SAXException {
        System.out.println("Start element: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void warning(SAXParseException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Fatal error: " + e.getMessage());
    }
}