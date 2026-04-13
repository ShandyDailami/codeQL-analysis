import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_29599_XMLParser_A03 extends DefaultHandler {
    public java_29599_XMLParser_A03() {
        super();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             String version) throws SAXException {
        // Your unique code here.
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // Your unique code here.
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // Your unique code here.
        String data = new String(ch, start, length);
        System.out.println("Character Data: " + data);
    }

    public static void main(String[] args) {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new UniqueXMLParser());
        try {
            reader.parse("src/test.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}