import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_15293_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isElement = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        isElement = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isElement) {
            System.out.println("Element: " + currentElement + ", Text: " + new String(ch, start, length));
        }
    }
}