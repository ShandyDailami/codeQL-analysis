import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_29404_XMLParser_A08 extends DefaultHandler {
    private int count;

    public static void main(String[] args) {
        XmlParserExample parser = new XmlParserExample();
        parser.parse();
    }

    private void parse() {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(this);
            reader.parse("resources/sample.xml");
            System.out.println("Number of 'A08_IntegrityFailure' elements: " + count);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("A08_IntegrityFailure")) {
            count++;
        }
    }
}