import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;

public class java_31573_XMLParser_A08 extends DefaultHandler {

    private String lastNodeName;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        lastNodeName = qName;
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastNodeName != null) {
            String value = new String(ch, start, length);
            System.out.println("Value for Node: " + value);
            lastNodeName = null;
        }
    }

    public static void main(String[] args) {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new MyXMLParser());

        try {
            reader.parse("src/main/resources/sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}