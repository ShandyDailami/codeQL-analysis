import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18245_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("yourfile.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAttribute = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currentElement = qName;
        bName = true;
        bAttribute = false;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            System.out.println("Element: " + currentElement);
            bName = false;
        }

        if (bAttribute) {
            String attributeValue = new String(ch, start, length);
            System.out.println("Attribute Value: " + attributeValue);
            bAttribute = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        currentElement = "";
    }

    @Override
    public void startPrefixMapping(String prefix, String uri)
            throws SAXException {
        // Do nothing
    }

    @Override
    public void endPrefixMapping(String prefix)
            throws SAXException {
        // Do nothing
    }
}