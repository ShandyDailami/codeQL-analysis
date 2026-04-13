import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXHandler;

public class java_10868_XMLParser_A08 {

    public static void main(String[] args) {
        parseXML("src/resources/test.xml", new MySAXHandler());
    }

    public static void parseXML(String fileName, SAXHandler handler) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(fileName);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MySAXHandler implements SAXHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Start of Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        System.out.println("Processing Instruction: " + target + ", " + data);
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start Prefix Mapping: " + prefix + ", " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("End Prefix Mapping: " + prefix);
    }
}