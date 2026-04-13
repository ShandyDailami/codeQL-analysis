import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class java_17025_XMLParser_A08 extends DefaultHandler {

    private boolean a08IntegrityFailureFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("a08_IntegrityFailure")) {
            a08IntegrityFailureFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("a08_IntegrityFailure")) {
            a08IntegrityFailureFound = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (a08IntegrityFailureFound) {
            // process the characters
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\"?>\n" +
                "<root>\n" +
                "<a08_IntegrityFailure>data1</a08_IntegrityFailure>\n" +
                "<a08_IntegrityFailure>data2</a08_IntegrityFailure>\n" +
                "</root>";

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new StringReader(xml), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}