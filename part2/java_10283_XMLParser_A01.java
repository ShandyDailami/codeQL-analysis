import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_10283_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Create a SAXReader
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            // Provide a handler to parse the XML
            saxParser.parse(new File("path_to_your_file.xml"), new MyHandler(xmlReader));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {
    private org.xml.sax.XMLReader xmlReader;

    public java_10283_XMLParser_A01(org.xml.sax.XMLReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
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