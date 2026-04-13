import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_00492_XMLParser_A08 extends DefaultHandler {
    private String currentElement;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = null;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null) {
            System.out.println(currentElement + ": " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("sample.xml"), new XMLParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}