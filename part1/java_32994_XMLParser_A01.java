import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_32994_XMLParser_A01 extends DefaultHandler {
    private boolean bName;
    private boolean bAge;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            bName = true;
            bAge = true;
        }
        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        }
        if (qName.equalsIgnoreCase("age")) {
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            bName = true;
            bAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        }
        if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
        bName = true;
        bAge = true;
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MyXMLParser handler = new MyXMLParser();
            parser.parse(new File("src/students.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}