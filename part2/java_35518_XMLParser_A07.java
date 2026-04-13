import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_35518_XMLParser_A07 extends DefaultHandler {
    private List<String> authorNames;
    private String currentElement;

    public java_35518_XMLParser_A07() {
        authorNames = new ArrayList<>();
    }

    @Override
    public void startDocument() throws SAXException {
        // This is called when the document starts
    }

    @Override
    public void endDocument() throws SAXException {
        // This is called when the document ends
        for (String name : authorNames) {
            System.out.println(name);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // This is called when an element starts
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // This is called when an element ends
        if (qName.equals("author")) {
            authorNames.add(currentElement);
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // This is called when characters are encountered
        if (currentElement != null && currentElement.equals("name")) {
            authorNames.add(new String(ch, start, length));
        }
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}