import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_10830_XMLParser_A03 extends DefaultHandler {
    private List<String> names = new ArrayList<>();

    public List<String> getNames() {
        return names;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of the document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of the document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
        names.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
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
}