import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_15623_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");

        // Start of your code
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SAXParserHandler handler = new SAXParserHandler();

            reader.setContentHandler(handler);
            reader.parse(xmlFile);

            System.out.println("Parsing completed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        // End of your code
    }
}

class SAXParserHandler implements org.xml.sax.helpers.DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of the document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of the document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start of " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        System.out.println("Characters: " + value);
    }
}