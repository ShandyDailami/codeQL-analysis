import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_08028_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XMLHandler());
            parser.parse(new File("sample.xml"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bValue = false;
    private String currentValue = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("value")) {
            bValue = true;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (bName) {
            bName = false;
            String value = new String(chars, start, length);
            System.out.println("Name: " + value);
        } else if (bValue) {
            bValue = false;
            currentValue = new String(chars, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("element")) {
            System.out.println("Value: " + currentValue);
        }
    }
}