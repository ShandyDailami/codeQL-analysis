import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_21164_XMLParser_A07 extends DefaultHandler {
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element: " + qName);
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Chars: " + new String(ch, start, length));
    }

    public static void main(String[] args) {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new XMLParser());
        try {
            reader.parse("src/test.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}