import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import org.xml.sax.helpers.DefaultHandlerSupport;

public class java_34608_XMLParser_A03 extends DefaultHandlerSupport {
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End element: " + qName);
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public static void main(String[] args) {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new MyXMLParser());
        try {
            reader.parse("http://example.com/books.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}