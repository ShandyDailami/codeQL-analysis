import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_13822_XMLParser_A07 {
    private static class MyHandler extends BasicHandler {
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            String name = attributes.getValue("name");
            String value = attributes.getValue("value");

            // Handle element and attribute
            // ...

            super.startElement(uri, localName, qName, attributes);
        }
    }

    public static void main(String[] args) {
        String xmlData = "<root><element name='item1' value='1' /><element name='item2' value='2' /></root>";

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse("data.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}