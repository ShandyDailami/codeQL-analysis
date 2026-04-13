import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_00377_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            XMLHandler xmlHandler = new XMLHandler();
            saxParser.parse(new File("sample.xml"), xmlHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    private boolean isElement = false;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isElement = true;
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isElement) {
            String elementContent = new String(ch, start, length);
            System.out.println("Element: " + currentElement + ", Content: " + elementContent);
            isElement = false;
        }
    }
}