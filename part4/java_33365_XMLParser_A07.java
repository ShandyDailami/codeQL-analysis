import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_33365_XMLParser_A07 {
    public static void main(String[] args) {
        // Step 1: Create a SAXParserFactory instance
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        // Step 2: Get a SAXParser instance with the factory
        SAXParser saxParser = saxParserFactory.newSAXParser();

        // Step 3: Create a new XMLReader instance
        XMLReader xmlReader = saxParser.getXMLReader();

        // Step 4: Set a new ContentHandler
        xmlReader.setContentHandler(new ContentHandlerImpl());

        // Step 5: Parse the XML document
        try {
            saxParser.parse("src/main/resources/authfailure.xml", xmlReader);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}

class ContentHandlerImpl implements ContentHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        System.out.println("Ignorable whitespace: " + new String(ch, start, length));
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        System.out.println("Processing instruction: " + target + ", " + data);
    }

    @Override
    public void setDocumentLocator(DocumentLocator locator) {
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start of prefix mapping: " + prefix + ", " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("End of prefix mapping: " + prefix);
    }
}