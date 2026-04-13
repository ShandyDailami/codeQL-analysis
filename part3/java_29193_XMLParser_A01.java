import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_29193_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // replace with your xml file
        SAXParserHandler handler = new SAXParserHandler();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(new File(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler extends DefaultHandler {

    private boolean isPerson = false;
    private boolean isName = false;
    private boolean isAge = false;
    private String name;
    private int age;

    @Override
    public void startDocument() {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("person")) {
            isPerson = true;
        }
        if (qName.equalsIgnoreCase("name")) {
            isName = true;
        }
        if (qName.equalsIgnoreCase("age")) {
            isAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("person")) {
            isPerson = false;
        }
        if (qName.equalsIgnoreCase("name")) {
            isName = false;
        }
        if (qName.equalsIgnoreCase("age")) {
            isAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isPerson) {
            System.out.println("Person: " + new String(ch, start, length));
        }
        if (isName) {
            name = new String(ch, start, length);
        }
        if (isAge) {
            age = Integer.parseInt(new String(ch, start, length));
        }
    }

    @Override
    public void fatalError(String error) {
        System.out.println("Fatal Error: " + error);
    }

    @Override
    public void warning(String msg) {
        System.out.println("Warning: " + msg);
    }
}