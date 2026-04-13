import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_15599_XMLParser_A01 extends DefaultHandler {
    private boolean accessControlElementFound = false;

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        File inputFile = new File("input.xml");
        BrokenAccessControlParser handler = new BrokenAccessControlParser();
        saxParser.parse(inputFile, handler);
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if ("accessControl".equals(qName)) {
            accessControlElementFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (accessControlElementFound) {
            throw new SAXException("Access control element found, please replace it!");
        }
    }
}