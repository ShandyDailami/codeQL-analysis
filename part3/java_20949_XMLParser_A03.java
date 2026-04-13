import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_20949_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("example.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder data;
    private boolean bPerson;

    @Override
    public void startDocument() throws SAXException {
        data = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Person")) {
            bPerson = true;
            data.setLength(0);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bPerson) {
            if (qName.equalsIgnoreCase("Name")) {
                System.out.println("Name: " + data.toString());
            } else if (qName.equalsIgnoreCase("Age")) {
                System.out.println("Age: " + data.toString());
            } else if (qName.equalsIgnoreCase("Person")) {
                bPerson = false;
            }
            data.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bPerson) {
            data.append(new String(ch, start, length));
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Parsed successfully!");
    }
}