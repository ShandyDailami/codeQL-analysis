import java.io.File;
import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class java_34312_XMLParser_A08 extends DefaultHandler {

    public java_34312_XMLParser_A08() throws SAXException {
        super();
    }

    public void parse(String file) throws Exception {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(this);
        reader.setErrorHandler(this);
        reader.parse(new File(file));
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName)
            throws SAXException {
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
    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    public static void main(String args[]) {
        try {
            XMLParser parser = new XMLParser();
            parser.parse("yourfile.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}