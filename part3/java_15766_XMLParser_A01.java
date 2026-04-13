import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_15766_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(new File("example.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private boolean bId = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
            bId = true;
        }
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        }
        if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
        if (qName.equalsIgnoreCase("id")) {
            bId = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
            bId = false;
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
        if (bId) {
            System.out.println("ID: " + new String(ch, start, length));
        }
    }
}