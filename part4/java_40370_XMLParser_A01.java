import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class java_40370_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";

        try {
            InputStream inputStream = new FileInputStream(new File(xmlFile));
            XMLErrorHandler errorHandler = new CustomErrorHandler();
            XMLParser parser = new SAXParser(errorHandler);
            DefaultHandler defaultHandler = new CustomDefaultHandler();

            parser.setContentHandler(defaultHandler);
            parser.parse(inputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class CustomDefaultHandler extends DefaultHandler {
    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}

class CustomErrorHandler implements XMLErrorHandler {
    @Override
    public void fatalError(SAXException ex) throws SAXException {
        System.out.println("Fatal error: " + ex.getMessage());
    }

    @Override
    public void error(SAXException ex) throws SAXException {
        System.out.println("Error: " + ex.getMessage());
    }

    @Override
    public void warning(SAXException ex) throws SAXException {
        System.out.println("Warning: " + ex.getMessage());
    }

    @Override
    public void info(SAXException ex) throws SAXException {
        System.out.println("Info: " + ex.getMessage());
    }
}