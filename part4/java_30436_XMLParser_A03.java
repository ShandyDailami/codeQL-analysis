import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.StringEntityHandler;
import org.xml.sax.xmlreader.XMLReaderImpl;

public class java_30436_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml";

        SAXReader saxReader = new SAXReader();

        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setEntityHandler(new StringEntityHandler(""));

            xmlReader.setContentHandler(new MyContentHandler());

            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements ContentHandler {

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of element " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
    }

    public void processingInstruction(String target, String data) throws SAXException {
        System.out.println("Processing Instruction: " + target + " " + data);
    }

    public void comment(char[] ch, int start, int length) throws SAXException {
        System.out.println("Comment: " + new String(ch, start, length));
    }

    public void endPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("End of Prefix Mapping " + prefix + "=" + uri);
    }

    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    public void error(SAXParseException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}