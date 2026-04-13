import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_32390_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();

            saxParser.parse(xmlFile, myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        // Implement your security-sensitive operations here
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Implement your security-sensitive operations here
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Implement your security-sensitive operations here
    }
}