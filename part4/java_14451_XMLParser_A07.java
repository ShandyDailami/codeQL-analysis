import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14451_XMLParser_A07 extends DefaultHandler {
    private String lastElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null) {
            System.out.println(lastElement + " = " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("sample.xml"), new MyXMLParser());
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}