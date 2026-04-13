import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_14782_XMLParser_A03 extends DefaultHandler {

    public void startElement(String uri, String localName, String qName,
                              String version) throws SAXException {
        System.out.println("Start element: " + localName);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End element: " + localName);
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String value = new String(ch, start, length).trim();
        if (value.isEmpty()) {
            return;
        }
        System.out.println("Character data: " + value);
    }

    public static void main(String[] args) throws Exception {
        XMLReader xr = XMLReaderFactory.createXMLReader();
        xr.setContentHandler(new XmlParser());
        xr.parse("src/example.xml");
    }
}