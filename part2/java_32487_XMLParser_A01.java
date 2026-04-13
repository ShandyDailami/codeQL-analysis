import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_32487_XMLParser_A01 extends DefaultHandler {

    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("Start Element: " + localName);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element: " + localName);
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Content: " + content);
    }

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            MyXMLParser handler = new MyXMLParser();
            reader.setContentHandler(handler);
            reader.parse("example.xml"); // replace with your xml file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}