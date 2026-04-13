import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_20699_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            
            SAXHandler saxHandler = new SAXHandler();
            xmlReader.setContentHandler(saxHandler);

            xmlReader.parse(inputFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class SAXHandler implements org.xml.sax.ContentHandler {
    private boolean bName;
    private boolean bAttribute;
    private String currentElement;

    public void startDocument() {}
    public void endDocument() {}

    public void startElement(String uri, String localName, String qName) {
        bName = true;
        bAttribute = false;
        currentElement = qName;
    }

    public void endElement(String uri, String localName, String qName) {
        bName = false;
        bAttribute = false;
        currentElement = qName;
    }

    public void characters(char[] ch, int start, int length) {
        if (bName) {
            System.out.println("Element: " + currentElement);
        }
        if (bAttribute) {
            System.out.println("Attribute: " + new String(ch, start, length));
        }
    }

    public void startPrefixMapping(String prefix, String uri) {}
    public void endPrefixMapping(String prefix, String uri) {}
    public void ignorableWhitespace(char[] ch, int start, int length) {}
    public void processingInstruction(String target, String data) {}
    public void setElementDecl(String uri, String localName, String qName, String namespaceURI) {}
}