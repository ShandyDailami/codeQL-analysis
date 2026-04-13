import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_13028_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());
            reader.parse("http://example.com/myfile.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    @Override
    public void startDocument() {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        System.out.println("Start Element: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) {
        System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
    }

    @Override
    public void processingInstruction(String target, String data) {
        System.out.println("Processing Instruction: " + target + " " + data);
    }

    @Override
    public void setDocumentLocator(org.xml.sax.Locator locator) {
        System.out.println("Set Document Locator: " + locator);
    }
}