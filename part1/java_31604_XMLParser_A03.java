import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.XMLReader;

public class java_31604_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            XMLParserHandler handler = new XMLParserHandler();
            reader.setContentHandler(handler);
            reader.parse("src/sample.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class XMLParserHandler implements ContentHandler {
    private boolean parsingStarted = false;
    private boolean rootStarted = false;
    private boolean elementStarted = false;

    private String currentElement = "";

    @Override
    public void startDocument() throws SAXException {
        // Nothing to do here
    }

    @Override
    public void endDocument() throws SAXException {
        // Nothing to do here
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        if (!parsingStarted) {
            parsingStarted = true;
            System.out.println("Parsing started");
        }

        if (!rootStarted) {
            rootStarted = true;
            System.out.println("Root element: " + qualifiedName);
        }

        currentElement = qualifiedName;
        System.out.println("Start of element: " + qualifiedName);
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        currentElement = qualifiedName;

        System.out.println("End of element: " + qualifiedName);

        if (currentElement.equals("book")) {
            System.out.println("Book element found");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Nothing to do here
    }
}