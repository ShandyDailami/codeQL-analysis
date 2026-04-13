import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_27495_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserHandler handler = new SAXParserHandler();
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(handler);

        try {
            reader.parse("src/main/resources/sample.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler extends BasicHandler {
    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        // Implement your own SAX logic here to handle XML elements
        System.out.println("Start element: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Implement your own SAX logic here to handle XML elements
        System.out.println("End element: " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Implement your own SAX logic here to handle XML characters
        String str = new String(ch, start, length);
        System.out.println("Characters: " + str);
    }
}