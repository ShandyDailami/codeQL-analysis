import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_08304_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/sample.xml");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            MyHandler myHandler = new MyHandler();

            saxParser.setContentHandler(myHandler);
            xmlReader.setContentHandler(myHandler);

            saxParser.setDTDValid(true);
            xmlReader.setDTDValid(true);

            saxParser.setEntityResolver(new MyEntityResolver());
            xmlReader.setEntityResolver(new MyEntityResolver());

            saxParser.parse(xmlFile, true);
            xmlReader.parse(xmlFile, true);

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("SAXParseException: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal SAXParseException: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("SAXParseException: " + e.getMessage());
    }
}

class MyEntityResolver implements javax.xml.parsers.EntityResolver {

    @Override
    public Object getEntity(String systemId) throws SAXException {
        // Return null or a default entity
        return null;
    }
}