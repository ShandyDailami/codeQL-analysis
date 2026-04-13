import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_01512_XMLParser_A03 {

    private BasicHandler handler;
    private XMLReader reader;

    public java_01512_XMLParser_A03() {
        handler = new BasicHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public void parse(String fileName) {
        reader.parse(fileName);
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        parser.parse("input.xml");
    }

    class MyHandler extends BasicHandler {

        @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            // TODO: perform security-sensitive operations related to injection
        }

    }
}