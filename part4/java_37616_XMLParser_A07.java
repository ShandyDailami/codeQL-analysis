import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_37616_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserExampleHandler handler = new SAXParserExampleHandler();

            XMLReaderFactory factory = XMLReaderFactory.newInstance();
            XMLReader reader = factory.createXMLReader();

            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);

            reader.parse(new File("data.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserExampleHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Start of " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Content: " + content);
    }

    @Override
    public void error(SAXException e) {
        System.err.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        System.err.println("Fatal Error: " + e.getMessage());
    }
}