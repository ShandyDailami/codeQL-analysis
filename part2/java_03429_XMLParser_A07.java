import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicSaxContext;

public class java_03429_XMLParser_A07 {
    public static void main(String[] args) {
        // Create an XMLReader
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.out.println("Error while creating the XMLReader: " + e.getMessage());
            return;
        }

        // Set the ContentHandler
        reader.setContentHandler(new MyContentHandler());

        // Parse the XML file
        try {
            reader.parse("test.xml");
        } catch (SAXException e) {
            System.out.println("Error while parsing the XML file: " + e.getMessage());
            return;
        }
    }
}

class MyContentHandler extends BasicSaxContext {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}