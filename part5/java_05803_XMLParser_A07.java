import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_05803_XMLParser_A07 extends DefaultHandler {

    public static void main(String[] args) {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(new MyXMLParser());
            xr.parse("example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal error: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }
}