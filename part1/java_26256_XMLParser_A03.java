import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.entries.ImmutableList;
import org.xml.sax.ext.ElementContentHandler;
import org.xml.sax.ext.EntityResolver;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.ext.NamespaceHandler;
import org.xml.sax.ext.ValidatorHandler;

public class java_26256_XMLParser_A03 extends DefaultHandler {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyXMLReader());
            reader.parse("example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End of element: " + qName);
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Character data: " + content);
    }
}