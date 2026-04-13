import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_05666_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("input.xml"), false);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName;
    private boolean bAge;
    private String tempValue;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (bName && qName.equalsIgnoreCase("age")) {
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            tempValue = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("name")) {
            System.out.println("Name: " + tempValue);
        } else if (qName.equalsIgnoreCase("age")) {
            System.out.println("Age: " + tempValue);
        }
    }
}