import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_01661_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("sample.xml");
            SAXParserHandler handler = new SAXParserHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler implements org.xml.sax.helpers.DefaultHandler {

    private int nodeCount;
    private int elementCount;

    public java_01661_XMLParser_A03() {
        nodeCount = 0;
        elementCount = 0;
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        nodeCount++;
        System.out.println("Start element : " + qName + ", Namespace : " + uri);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementCount++;
        System.out.println("End element : " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        System.out.println("Character data : " + value);
    }

    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal Error: " + error);
    }
}