import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.events.StartElement;
import org.xml.sax.events.Attribute;

public class java_11192_XMLParser_A08 extends DefaultHandler {
    private String currentElement;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(StartElement startElement) throws SAXException {
        currentElement = startElement.getName().getLocalPart();
        System.out.println("Start of element: " + currentElement);
    }

    @Override
    public void endElement(StartElement startElement) throws SAXException {
        currentElement = startElement.getName().getLocalPart();
        System.out.println("End of element: " + currentElement);
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        String content = new String(chars, start, length);
        System.out.println("Content of element: " + content);
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start of prefix mapping: " + prefix + " - " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("End of prefix mapping: " + prefix);
    }

    public static void main(String[] args) {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new XMLParser());

        try {
            reader.parse("src/main/resources/example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}