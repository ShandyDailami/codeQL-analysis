import java.io.File;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_01833_XMLParser_A01 extends DefaultHandler {
    private StringBuilder data = new StringBuilder();

    public void startDocument() throws SAXException {
        // This method gets called when the document starts.
    }

    public void endDocument() throws SAXException {
        // This method gets called when the document ends.
        System.out.println(data.toString());
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // This method gets called when an element starts.
        data.append(qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        // This method gets called when an element ends.
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // This method gets called when characters are found.
        data.append(new String(ch, start, length));
    }

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");  // Specify your XML file here
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyXMLParser handler = new MyXMLParser();
            saxParser.parse(xmlFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}