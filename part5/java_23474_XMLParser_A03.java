import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_23474_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), false);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName;
    private boolean bAge;
    private String currentElement;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        } else {
            if (bName && qName.equals("name")) {
                bName = false;
            } else if (bName && qName.equals("age")) {
                bAge = false;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        }
    }
}