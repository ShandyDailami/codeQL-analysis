import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_12091_XMLParser_A07 {
    public static void main(String[] args) throws Exception {
        File inputFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        XMLReader reader = parser.getXMLReader();
        reader.setContentHandler(handler);
        SAXSource source = new SAXSource(reader, inputFile);
        reader.parse(source);
    }
}

class MyHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Handle start elements here
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Handle end elements here
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Handle characters here
    }
}