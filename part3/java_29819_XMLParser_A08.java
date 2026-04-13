import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_29819_XMLParser_A08 extends DefaultHandler {
    
    private String lastElement;
    private String lastQName;
    private String lastValue;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        lastQName = localName;
        lastValue = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        lastValue = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Here you can add your security-sensitive operations related to A08_IntegrityFailure
        System.out.println("End element: " + lastElement + ", QName: " + lastQName + ", Value: " + lastValue);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MySAXHandler handler = new MySAXHandler();
        parser.parse("src/test.xml", handler);
    }
}