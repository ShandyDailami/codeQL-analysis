import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_29092_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        try {
            parser.parse(new File("src/example.xml"), new MyHandler());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Start of person: " + localName);
            bName = true;
            bAge = true;
            return;
        }
        if (bName) {
            System.out.println("Start of name: " + localName);
            bName = false;
        }
        if (bAge) {
            System.out.println("Start of age: " + localName);
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End of person: " + localName);
            return;
        }
        if (bName) {
            System.out.println("End of name: " + localName);
            bName = false;
        }
        if (bAge) {
            System.out.println("End of age: " + localName);
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName || bAge) {
            String s = new String(ch, start, length);
            System.out.println("Character data: " + s);
        }
    }
}