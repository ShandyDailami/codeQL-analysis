import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_32913_XMLParser_A03 extends DefaultHandler {
    public java_32913_XMLParser_A03() {
        super();
    }

    public void parse(String filename) {
        XMLReader xr = null;
        try {
            xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(this);
            xr.parse("https://your-xml-file.url");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (xr != null) {
                xr.getReader().close();
            }
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public static void main(String[] args) {
        new MyXMLParser().parse("https://your-xml-file.url");
    }
}