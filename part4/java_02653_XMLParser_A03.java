import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_02653_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserHandler handler = new SAXParserHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse("input.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler extends BasicHandler {

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
        printAttributes(attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element: " + qName);
    }

    private void printAttributes(org.xml.sax.Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("Attribute: "
                    + attributes.getQName(i) + " = " + attributes.getValue(i));
        }
    }
}