import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_41000_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        try {
            parser.parse(new File("input.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isElementFound;
    private String lastElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("element")) {
            isElementFound = true;
            lastElement = qName;
        }
    }

    @Override
    public java_41000_XMLParser_A07(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            isElementFound = false;
            lastElement = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isElementFound) {
            System.out.println("Found element: " + new String(ch, start, length));
        }
    }
}