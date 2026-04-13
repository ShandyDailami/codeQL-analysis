import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14101_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = parserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(inputFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isPersonName = false;
    private boolean isPersonAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Person")) {
            isPersonName = true;
            isPersonAge = true;
        } else if (isPersonName && qName.equalsIgnoreCase("Name")) {
            isPersonName = false;
        } else if (isPersonName && qName.equalsIgnoreCase("Age")) {
            isPersonAge = false;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (isPersonAge) {
            String age = new String(chars, start, length);
            System.out.println("Age: " + age);
        }
    }
}