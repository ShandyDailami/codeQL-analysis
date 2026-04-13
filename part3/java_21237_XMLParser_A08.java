import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_21237_XMLParser_A08 extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of Element: " + qName);
        // Here you can add code to handle attributes or perform security sensitive operations
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of Element: " + qName);
        // Here you can add code to handle end of element or perform security sensitive operations
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        System.out.println("Character Data: " + value);
        // Here you can add code to handle character data or perform security sensitive operations
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
        // Here you can add code to handle fatal error or perform security sensitive operations
    }
}