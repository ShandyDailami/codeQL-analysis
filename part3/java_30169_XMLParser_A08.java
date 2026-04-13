import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.entries.DefaultEntry;

public class java_30169_XMLParser_A08 extends DefaultHandler {

    public java_30169_XMLParser_A08() {
        super();
    }

    public void startElement(String uri, String localName, String qName,
                              org.xml.sax.Attributes attributes) throws SAXException {

        DefaultEntry entry = new DefaultEntry(qName);
        entry.setNamespace(uri);
        entry.setLocalName(localName);

        for (int i = 0; i < attributes.getLength(); i++) {
            entry.addAttribute(attributes.getQName(i), attributes.getValue(i));
        }

        // Log the entry
        System.out.println(entry.getLocalName() + " Element: Starts (" + entry.getNamespace() + ")");

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        // Log the entry
        System.out.println(qName + " Element: Ends (" + localName + ")");

    }

    public static void main(String[] args) {

        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            MyXMLParser handler = new MyXMLParser();
            parser.setContentHandler(handler);
            parser.parse("src/test.xml"); // replace with your xml file

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}